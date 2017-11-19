package net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 当客户端与服务器建立连接正常通信时关闭客户端，服务器可以正常发消息但会出SocketException: Broken
 * pipe错误。客户端再次连接时服务器的数据还能再次收到(会缓存消息)
 * 
 * @author Snake
 *
 */
public class Client
{
	
	
	public static void main(String[] args)
		throws UnknownHostException, IOException
	{
		Socket s = new Socket("localhost", 8888);
		InputStream inputStream = s.getInputStream();
		
		new Thread(new SocketRunnable(s)).start();
		
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
								System.out.println("read from server: " + line);
							}
						}
						catch (IOException e)
						{
							e.printStackTrace();
						}
					}
				}).start();
				InputStream in = System.in;
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader reader1 = new BufferedReader(isr);
				String line = null;
				while ((line = reader1.readLine()) != null)
				{
					writer.write(line + "\r\n");
					writer.flush();
					if ("quit".equals(line))
					{
						client.close();
					}
				}
				
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}
}
