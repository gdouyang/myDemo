package thread_test;

import java.util.Random;

public class ThreadLocalTest {
	static ThreadLocal<Integer> x = new ThreadLocal<Integer>();

	public static void main(String[] args) {
		
		for (int i = 0; i < 2; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()
							+ "has put data: " + data);
					x.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
	}

	static class A {
		public void get() {

		}
	}

	static class B {
		public void get() {

		}
	}
}
