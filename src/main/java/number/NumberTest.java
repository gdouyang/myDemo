package number;

public class NumberTest
{
	
	public static void main(String[] args)
	{
		// jisuan();
		jisuan2();
	}
	
	public static void jisuan()
	{
		System.out.println("0&1 =" + (0 & 1));// 与运算
		System.out.println("1|0 =" + (1 | 0));// 或运算
		// 定义一个8进制数,十进制为9
		byte b = 011;
		// 定义一个16进制数,十进制为483
		short s = 0x1E3;
		// java不显示地支持二进制数字,因为二进制的数字比较长
		System.out.println(Integer.toBinaryString(b));
		System.out.println(b);
		System.out.println(s);
		System.out.println("9的二进制：" + Integer.toBinaryString(9));
		System.out.println("9的八进制：" + Integer.toOctalString(9));
		System.out.println("9的十六进制：" + Integer.toHexString(9));
		/**
		 * 右移运算符 >> 用来将一个数的二进制位序列右移若干位。例如：a=a>>2，使a的二进制位右 移 2
		 * 位，移到右端的低位被舍弃，最高位则移入原来高位的值。如 a=00110111，则 a>>2=00001101;
		 * b=11010011，则b>>2=11110100。 右移一位相当于除2取商，而且用右移实现除法比除法运算速度要快。
		 */
		System.out.println(2 >> 2);
		/**
		 * 左移去处符 << 用来将一个数的二进制位序列左移若干位。例如：a = a<<2,使a的各二进制位左 移 2
		 * 位，右补0，若a=00001111,则a<<2=00111100。高位左移后溢出，舍弃不起作用。
		 * 在不产生溢出的情况下，左移一位相当于乘2，而且用左移来实现乘法比乘法运算速度要快
		 */
		System.out.println(2 << 2);
	}
	
	public static void jisuan2()
	{
		/**
		 * Integer类型在Java中大小为32位，
		 * 最大值2147483647二进制为0111，1111，1111，1111，1111，1111，1111，1111；
		 * 最小值-2147483648二进制为1000，0000，0000，0000，0000，0000，0000，0000；
		 * 其中首位为符号位0表示正数，1表示负数，当长度大于32位的时候就会出现溢出，Java会在显示时使用“补码”；
		 * 所以当定义一个int值为Integer
		 * .MAX_VALUE+2的时候二进制数为1000，0000，0000，0000，0000，0000，0000，0001，
		 * 这个时候它所表示的十进制是-2147483647；
		 */
		Integer max = Integer.MAX_VALUE;
		Integer b = Integer.MAX_VALUE + Integer.MAX_VALUE;
		Integer i_min = Integer.MIN_VALUE;
		System.out.println("int 最大值 " + max);
		System.out.println("int 最小值 " + i_min);
		System.out.println("int 长度 " + Integer.SIZE + " 位");
		System.out.println(b);
		System.out.println();
		// byte
		// 因为Java中byte是用8位来存储，只能表示-128~127之间的数，当由int强制类型转化为byte时，系统就采取了截取int后8位的做法。
		// java采用补码存储整数，int型为32位，byte为8位
		// 那么130在内存中的表示形式：00000000 00000000 00000000 10000010
		// 这样截取后8位就变成10000010，补码表示的时候第一位是符号位，0正1负，
		// 所以可以知道10000010肯定是一个负数了，再来看它的数值部分，
		// 补码由正数变负数，还是正数变负，方法：“按位取反，再加1”，
		// 所以0000010应该变为1111101 + 1 = 1111110(即126)
		// 又因为是负数，所以就截取变成-126了
		
		// 我们再来看下-130的例子(符号位是1，其余按位取反+1)
		// -130在内存中的表示形式：11111111 11111111 11111111 01111110
		// 这样截取后8位就变成01111110
		// 显然这是整数啊，然后数值部分是126
		// 64+32+16+8+4+2=126
		Byte b_max = Byte.MAX_VALUE;
		Byte b_min = Byte.MIN_VALUE;
		Byte b_max1 = (byte) (Byte.MAX_VALUE + new Byte((byte) 1));
		System.out.println("byte 最大值 " + b_max);
		System.out.println("byte 最小值 " + b_min);
		System.out.println("byte 长度 " + Byte.SIZE + " 位");
		System.out.println(b_max1.intValue());
		// 将byte还原成int做和0xff与运算
		System.out.println((byte) 192 & 0xff);
		System.out.println(0x7f);
		System.out.println();
		// short
		System.out.println("Short 最大值 " + Short.MAX_VALUE);
		System.out.println("Short 最小值 " + Short.MIN_VALUE);
		System.out.println("Short 长度 " + Short.SIZE + " 位");
		System.out.println();
		// long
		System.out.println("Long 最大值 " + Long.MAX_VALUE);
		System.out.println("Long 最小值 " + Long.MIN_VALUE);
		System.out.println("Long 长度 " + Long.SIZE + " 位");
		System.out.println();
		// char
		System.out.println("char 最大值 " + Character.MAX_VALUE);
		System.out.println("char 最小值 " + Character.MIN_VALUE);
		System.out.println("char 长度 " + Character.SIZE + " 位");
		System.out.println();
		// float
		System.out.println("float 最大值 " + Float.MAX_VALUE);
		System.out.println("float 最小值 " + Float.MIN_VALUE);
		System.out.println("float 长度 " + Float.SIZE + " 位");
		System.out.println();
		// double
		System.out.println("double 最大值 " + Double.MAX_VALUE);
		System.out.println("double 最小值 " + Double.MIN_VALUE);
		System.out.println("double 长度 " + Double.SIZE + " 位");
		System.out.println();
		// boolean
		System.out.println("boolean 只有ture/false无大小，无长度");
		
	}
}
