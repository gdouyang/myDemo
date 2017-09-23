package test;

public class InstanceOf
{
	
	public static void main(String[] args)
	{
		double d1 = 1d;
		Double d2 = 2d;
		Object d3 = d1;// 把这个基本类型的引用赋值给另一个对象类型的引用就可以使用instanceof判断对象的类型了
		Object d4 = d2;
		System.out.println(d2 instanceof Double);
		System.out.println(d3 instanceof Double);
		System.out.println(d4 instanceof Double);
	}
}
