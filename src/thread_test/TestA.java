package thread_test;

/**
 * 各个线程对静态方法的访问是交叉执行的，但是这并不影响各个线程静态方法print()中sum值的计算。也就是说，
 * 在此过程中没有使用全局变量的静态方法在多线程中是安全的，静态方法是否引起线程安全问题主要看该静态方法是否对全局变量（静态变量static
 * member）进行修改操作
 *
 * @author OuYangGuoDong 2015年8月12日-下午9:15:12
 */
public class TestA
{
	
	public static void main(String[] args)
	{
		new TestA().init();
	}
	
	void init()
	{
		final OutPut output = new OutPut();
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(100);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.out.println("A=" + output.print("aaaaaaaaaaaaaa-"));
				}
			}
		}).start();
		new Thread(new Runnable()
		{
			
			@Override
			public void run()
			{
				while (true)
				{
					try
					{
						Thread.sleep(200);
					}
					catch (InterruptedException e)
					{
						e.printStackTrace();
					}
					System.err.println("B=" + output.print("bbbbbbbbbbbbbb"));
				}
			}
		}).start();
	}
	
	class OutPut
	{
		
		public String print(String name)
		{
			int len = name.length();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < len; i++)
			{
				sb.append(name.charAt(i));
				// System.out.print(name.charAt(i));
			}
			// System.out.println();
			return sb.toString();
		}
	}
}
