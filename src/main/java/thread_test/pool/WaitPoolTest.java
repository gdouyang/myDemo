package thread_test.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 自定义策略的线程池，当线程池满时让主线程等待
 * 
 */
public class WaitPoolTest
{
	
	public static void main(String[] args)
	{
		Thread mainThread = Thread.currentThread();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10,
				1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10),
				new WaitPolicy(mainThread));
		
		/**
		 * ArrayBlockingQueue的容量(capacity)影响最终的线程数，maximumPoolSize+
		 * capacity为最大可以接收的线程数，大于这个值后面的任务不会执行
		 */
		for (int i = 0; i < 31; i++)
		{
			int task = i;
			System.out.printf("get task %s \r\n", task+1);
			/**
			 * 创建时提供的是Runnable接口并不是Thread类所以并不会马上创建新线程
			 */
			threadPoolExecutor.execute(new Runnable()
			{
				
				@Override
				public void run()
				{
					try
					{
						TimeUnit.SECONDS.sleep(3);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.printf("task %s is done, ActiveCount: %s, threadName: %s \r\n", 
							task, 
							Thread.currentThread().getName(), 
							threadPoolExecutor.getActiveCount()
					);
					LockSupport.unpark(mainThread);
				}
			});
		}
	}
	
	public static class WaitPolicy implements RejectedExecutionHandler {
		Thread t;
        public WaitPolicy(Thread t) {
        	this.t= t;
        }

        @Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
        	System.out.println("pool is full main thread was wait");
        	LockSupport.park(this.t);
        }
    }
}
