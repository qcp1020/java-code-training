package interview;

/**
 * @author qinchenpu
 * @project leetcode
 * @Date 2022/6/20
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */

public class XiaoManKeji {
    private static final Object lock = new Object();
    /**
     * 轮次标志：1 = 线程A，2 = 线程B，3 = 线程C
     */
    private static int turn = 1;

    public static void main(String[] args) {
        new MyThread("线程A", 1).start();
        new MyThread("线程B", 2).start();
        new MyThread("线程C", 3).start();
    }


    protected static class MyThread extends Thread {

        private final int turnId;

        MyThread(String name, int turnId) {
            super(name);
            this.turnId = turnId;
        }

        @Override
        public void run() {
            for (int num = 1; num <= 10; num++) {
                synchronized (lock) {
                    // 用 while 而不是 if：防止虚假唤醒
                    while (turn != turnId) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt(); // 恢复中断标记
                            return;                             // 中断即退出
                        }
                    }
                    System.out.println(getName() + ": " + num);
                    turn = turn % 3 + 1;      // 交出执行权
                    lock.notifyAll();   // 唤醒对方
                }
            }
        }
    }
}
