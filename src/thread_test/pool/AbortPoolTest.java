package thread_test.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * AbortPolicy的线程池
 * 
 * @author OuYangGuoDong 2017年8月13日-下午5:00:42
 */
public class AbortPoolTest
{
	
	public static void main(String[] args)
	{
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
				1, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(10),
				new AbortPolicy());
		/**
		 * ArrayBlockingQueue的容量(capacity)影响最终的线程数，maximumPoolSize+
		 * capacity为最大可以接收的线程数，大于这个值后面的任务不会执行
		 */
		for (int i = 0; i < 31; i++)
		{
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
						Thread.sleep(10000L);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
	}
}
