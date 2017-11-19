package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * <ol>
 * <li>当客户端与服务器建立连接正常通信时关闭客户端,服务器续费发消息会出SocketException: Broken pipe异常；</li>
 * <li>继续在控制台输入信息不会出错,此时并没有发送给客户端只是在控制台中打信息缓存下来了；</li>
 * <li>客户端再次连接时服务器的数据还能再次收到(控制台中之前输入的内容)；</li>
 * </ol>
 * 客户端关机或断网服务器无法知道，只有在再发送信息时才能知道；
 * 
 */
public class Server
{
	
	
	public static void main(String[] args)
		throws IOException
	{
		ServerSocket ss = new ServerSocket(8888);
		// ss.setSoTimeout(1000 * 10);
		while (true)
		{
			Socket accept = ss.accept();
			// accept.setSoTimeout(1000 * 10);
			new Thread(new SocketRunnable(accept)).start();
			
		}
	}
	
	static class SocketRunnable implements Runnable
	{
		
		
		public Socket client;
		
		private BufferedReader reader;
		
		private BufferedWriter writer;
		
		public SocketRunnable(Socket client)
		{
			this.client = client;
			
			InputStream inputStream;
			try
			{
				inputStream = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(inputStream);
				reader = new BufferedReader(isr);
				
				OutputStream outputStream = client.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(outputStream);
				writer = new BufferedWriter(osw);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		@Override
		public void run()
		{
			try
			{
				new Thread(new Runnable()
				{
					
					
					@Override
					public void run()
					{
						String line = null;
						try
						{
							while ((line = reader.readLine()) != null)
							{
								System.out.println("read from client: " + line);
							}
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
						
					}
				}).start();
				
				// 标准输入流，里面的内容如果没有被读取会一直保存着
				InputStream in = System.in;
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader reader1 = new BufferedReader(isr);
				String line = null;
				while ((line = reader1.readLine()) != null)
				{
					if (client.isClosed())
					{
						System.out.println("client is closed");
					}
					System.out.println("send from server: " + line);
					writer.write(line + "\r\n");
					writer.flush();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
}
