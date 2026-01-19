package interview;

public class Alibaba {
	private static
	Object lock = new Object();
	private static volatile int number = 1;

	public static void main(String[] args) {
		Thread P1 = new Thread() {
			public void run() {
				while (number <= 100) {
					synchronized (lock) {
						if (number % 2 == 1) {
							System.out.println("线程P1: " + number++);
						} else {
							try {
								lock.wait(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};

		Thread P2 = new Thread() {
			public void run() {
				while (number <= 100) {
					synchronized (lock) {
						if (number % 2 == 0) {
							System.out.println("线程P2: " + number++);
						} else {
							try {
								lock.wait(100);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		};
		P1.start();
		P2.start();
	}

}
