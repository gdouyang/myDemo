package io_test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritableByteChannel;

public class ChargenClient {
	public static int DEFAULT_PORT=19;
	
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Usage: java ChargenClient host [port]");
			return;
		}
		
		int port ;
		try{
			port = Integer.parseInt(args[1]);
		}catch(Exception ex){
			port = DEFAULT_PORT;
		}
		try{
			SocketAddress address = new InetSocketAddress(args[0],port);
			SocketChannel client = SocketChannel.open(address);
			
			ByteBuffer buffer = ByteBuffer.allocate(74);
			WritableByteChannel out = Channels.newChannel(System.out);
			
			//设置为非阻塞连接
			client.configureBlocking(false);
			while(true){
				int n = client.read(buffer);
				if(n > 0){
					buffer.flip();
					out.write(buffer);
					buffer.clear();
				}else if(n == -1){
					break;
				}
					
			}
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
}
