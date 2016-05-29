package test;

/**
 * 移位运算符有双目移位运算符：<<（左移）和>>（右移）
 * 左移运算是将一个二进制位的操作数按指定移动的位数向左移位，移出位被丢弃，右边的空位一律补0。右移运算是将一个二进制位的操作数按指定移动的位数向右移动
 * ，移出位被丢弃
 * ，左边移出的空位或者一律补0，或者补符号位，这由不同的机器而定。在使用补码作为机器数的机器中，正数的符号位为0，负数的符号位为1。（均由机器来定）
 * 
 * @author OuYangGuoDong 2015年5月5日-下午9:26:38
 */
public class Operator
{
	
	public static void main(String[] args)
	{
		int m = -7;
		System.out.println("m的二 进 制码是：" + Integer.toBinaryString(m));
		System.out.println("m>>2的二进制码是：" + Integer.toBinaryString(m >> 2));
		System.out.println("(m>>2)=" + (m >> 2));
		System.out.println("m<<2的二进制码是：" + Integer.toBinaryString(m << 2));
		System.out.println("(m<<2)=:" + (m << 2));
		System.out.println("m>>>24的二进制码是：" + Integer.toBinaryString(m >>> 24));
		System.out.println(" m>>>24 :" + (m >>> 24));
		System.out.println(64 << 1);
		System.out.println(0xF0 & 11);
		System.out.println(Integer.toBinaryString(0xF0));
	}
}
