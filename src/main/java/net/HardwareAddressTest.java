package net;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class HardwareAddressTest {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		test1();

	}

	public static void test2() {
		try {
			System.out.println(System.getProperty("os.name"));
			System.out.println(System.getProperty("user.dir"));
			System.out.println(System.getProperty("user.home"));
			System.out.println(InetAddress.getByName(System.getProperty("user.name") + "-PC"));
			NetworkInterface net = NetworkInterface.getByInetAddress(InetAddress.getByName("192.168.0.106"));
			byte[] bs = net.getHardwareAddress();
			String mac = "";
			if (bs != null)
				for (byte b : bs) {
					String s = Integer.toHexString(b);
					if (b < 0)
						mac += s.substring(s.length() - 2, s.length()) + "-";
					else
						mac += s + "-";
				}
			if (net.isVirtual()) {
				System.out.println("is virtual");
			}
			if (mac.length() > 1)
				System.out.println(mac.substring(0, mac.length() - 1).toUpperCase());
			System.out.println(net.getName());
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void test1() throws SocketException {
		Enumeration<NetworkInterface> netWork = NetworkInterface.getNetworkInterfaces();

		while (netWork.hasMoreElements()) {
			NetworkInterface net = netWork.nextElement();
			for (InterfaceAddress inter : net.getInterfaceAddresses()) {
				System.out.println(inter.getNetworkPrefixLength());
			}
			byte[] bs = net.getHardwareAddress();
			String mac = "";
			if (bs != null)
				for (byte b : bs) {
					String s = Integer.toHexString(b);
					if (b < 0)
						mac += s.substring(s.length() - 2, s.length()) + "-";
					else
						mac += s + "-";
				}
			if (net.isVirtual()) {
				System.out.println("is virtual");
			}
			if (mac.length() > 1)
				System.out.println(mac.substring(0, mac.length() - 1));
		}
	}
}
