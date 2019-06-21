package test;

import com.fasterxml.jackson.databind.SerializationFeature;

public class EnumTest {
public static void main(String[] args) {
	System.out.println(SerializationFeature.CLOSE_CLOSEABLE.ordinal()
			);
	System.out.println(SerializationFeature.WRAP_ROOT_VALUE.ordinal()
			);
	
	System.out.println("1 & 2 = 01&10 = " + (1 & 2));
	System.out.println("1 &~ 2 = 01&(~10) = 01&01 = " + (1 &~ 2));
	System.out.println("~ 2 = 0000000000000000000010 -> 11111111111111111111111111111101 = " + (~ 2));
	System.out.println(Integer.toBinaryString(-3));
}
}
