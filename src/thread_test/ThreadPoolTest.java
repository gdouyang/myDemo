package thread_test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 * @author snake
 *
 */
public class ThreadPoolTest {

	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			final int task= i;
			threadPool.execute(new Runnable() {
				
				@Override
				public void run() {
					for(int j = 0;j<10;j++){
					System.out.println(Thread.currentThread().getName()
							+ "is looping of "+ j +" task of " + task);
					}
				}
			});
		}
		System.out.println("主线程完毕！"+Thread.currentThread().getName());
		threadPool.shutdown();
	}

}
