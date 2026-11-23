package qinchenpu.tool;

/**
 * 打印顺序控制：让并发线程的输出按"文件编号"顺序落地。
 *
 * <p>为什么需要它：5 个线程并发执行，谁先跑完谁先打印，输出顺序是随机的；
 * 而试题样例的输出是 1→5 有序的，人眼/脚本核对时更友好。这里加一个"打印顺序闸门"：
 * 编号 i 的线程打印前先等到 {@code next == i}，打完把 next 加一并唤醒其他线程。
 *
 * <p>注意：它只串行化"打印"这一小步（微秒级），日志解析本身仍然是完全并行的，
 * 不会影响并发收益。
 *
 * <p>防死锁：等待带 3 秒上限——万一某个线程异常退出没走到打印，后面的线程最多等 3 秒
 * 就直接打印（宁可乱序，也不能让整个程序卡死）。
 *
 * <p>复杂度：单次打印平均 O(1)，最坏 O(线程数) 次唤醒；空间 O(1)。
 */
public class OrderedPrinter {

    private final Object lock = new Object();

    /** 下一个轮到谁打印（文件编号从 1 开始）。 */
    private int next = 1;

    /** 是否为每行输出追加一个空行（对齐试题样张的排版）。 */
    private final boolean spaced;

    /** 等待上限：超过则认为前序线程出了异常，直接打印，避免死等。 */
    private static final long WAIT_TIMEOUT_MS = 3000L;

    public OrderedPrinter(boolean spaced) {
        this.spaced = spaced;
    }

    /**
     * 按编号顺序打印一行。
     *
     * @param sequence 本条输出对应的序号（文件编号）
     * @param line     输出内容
     */
    public void printInOrder(int sequence, String line) {
        synchronized (lock) {
            long deadline = System.currentTimeMillis() + WAIT_TIMEOUT_MS;
            while (next != sequence) {
                long remain = deadline - System.currentTimeMillis();
                if (remain <= 0L) {
                    break;                       // 超时：不再等前序线程，先输出
                }
                try {
                    lock.wait(remain);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            if (next == sequence) {
                next++;
            }
            System.out.println(line);
            if (spaced) {
                System.out.println();
            }
            lock.notifyAll();
        }
    }
}
