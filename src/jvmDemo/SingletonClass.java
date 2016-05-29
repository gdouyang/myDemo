package jvmDemo;

/**
 * 类的加载、连接与初始化 
 * 1.加载：查找并加载类的二进制数据（由硬盘加载到内存）；
 * 
 * 2.连接：（连接就是将已经读入到内存的类的二进制数据合并到虚拟机的运行时环境中去） 
 * - 验证：确保被加载的类的正确性； 
 * - 准备：为类的静态变量分配内在，并将其初始化为默认值； 
 * - 解析：把类中的符号引用转换为直接引用；
 * 
 * 3.初始化：为类的静态变量赋予正确的初始值。
 */
class Singleton {
	// 放在前面的时候会输出 1 ，0; 放下最下面会输出1，1；
	private static Singleton singleton = new Singleton();
	private static int counter1;
	private static int counter2 = 0;
	// private static Singleton singleton = new Singleton();

	private Singleton() {
		counter1++;
		counter2++;
	}

	public static Singleton getInstance() {
		return singleton;
	}

	public int getCounter1() {
		return counter1;
	}

	public int getCounter2() {
		return counter2;
	}

}

public class SingletonClass {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println("counter1 = " + singleton.getCounter1());
		System.out.println("counter1 = " + singleton.getCounter2());

	}
}
