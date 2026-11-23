package interview;

public class Alibaba {
    private static Object lock = new Object();
    private static volatile int number = 1;
    private static final int MAX = 30;

    public static void main(String[] args) {
        new Thread(() -> print(1), "线程A").start();
        new Thread(() -> print(2), "线程B").start();
        new Thread(() -> print(3), "线程C").start();
    }

    private static void print(int parity) {
        while (true) {
            synchronized (lock) {
                // 用 while 防止虚假唤醒；条件不满足就释放锁等待
                while (number <= MAX && (number - parity) % 3 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();   // 恢复中断标志
                        return;
                    }
                }
                // 锁内复核边界，避免在锁外判断导致的越界打印
                if (number > MAX) {
                    lock.notifyAll();   // 唤醒同伴一起退出
                    return;
                }
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notifyAll();       // 状态已变，唤醒对方
            }
        }
    }

}
