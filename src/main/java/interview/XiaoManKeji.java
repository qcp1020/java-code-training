package interview;

/**
 * @author qinchenpu
 * @project leetcode
 * @Date 2022/6/20
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */

public class XiaoManKeji {
    public static int num = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread myThread = new MyThread();
        Thread myThread2 = new MyThread(); 
        myThread.start();
        myThread2.start();
    }


    protected static class MyThread extends Thread {

        public void run() {
            int num = 1;
            while (num <= 10) {
                System.out.println(Thread.currentThread() + ": " +num);
                num++;
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
