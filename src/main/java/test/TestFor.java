package test;

public class TestFor
{
	
	static int age;
	
	static boolean method(String str)
	{
		System.out.print(str);
		return true;
	}
	
	public static void main(String[] args)
	{
		int i = 0;
		for (method("A"); method("B") && i < 2; method("C"))
		{
			i++;
			method("D");
		}
		// 输出是什么？
		System.out.println();
		age++;
		System.out.println(age);
	}
}
