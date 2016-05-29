package io_test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;

public class GetResourceByNet
{
	
	public static void main(String[] args)
		throws Exception
	{
		InetAddress add = getAddress("180.97.33.108");
		Socket s = new Socket(add, 80);
		s.getOutputStream().write("hello".getBytes());
		s.getOutputStream().flush();
		
		URI uri = new URI("www.baidu.com");
		System.out.println(uri);
		
		InputStream in = s.getInputStream();
		OutputStream out = new FileOutputStream("d:/12311.txt");
		byte[] b = new byte[1024];
		int i = 0;
		while ((i = in.read(b)) != -1)
		{
			System.out.println(b);
			out.write(b, 0, i);
		}
	}
	
	static InetAddress getAddress(String address)
		throws UnknownHostException
	{
		String[] ss = address.split("\\.");
		byte[] bytes = new byte[ss.length];
		for (int i = 0; i < ss.length; i++)
		{
			bytes[i] = Integer.valueOf(ss[i]).byteValue();
			// System.out.println(ss[i] + "----" + bytes[i]);
		}
		return InetAddress.getByAddress(bytes);
	}
}
