package thread_test;

/**
 * 只有变量或数据才能这么说，而函数方法只是一段计算机指令而已，多线程运行的代码在内存中就一块，只是堆栈和寄存器中的内容（数据）不一样而已。
 * 同步是为了数据互斥访问，并非是代码。 <br>
 * </p>
 * 栈帧是用于支持虚拟机进行方法调用和方法执行的数据结构，在每次进入一个方法的时候，都会生成该方法的栈帧，并入栈。当方法执行完时，则将对应的栈帧出栈。
 * 每个方法对应一个栈帧，每次只有栈顶的栈帧有效，这样，各个方法的调用、内部变量的使用便不会相互干扰。
 * 在一个栈帧中，包含了局部变量表、操作数栈、动态链接、方法返回地址等各个部分的作用和数据结构。<br>
 * <p>
 * 1、 局部变量表。<br>
 * 局部变量表，顾名思义，用于存储某个方法内部的变量和方法参数。变量表中，以变量槽（Slot）作为基本单位，来存储各个变量。
 * 能够存储基本类型和reference、returnAddress类型。<br>
 * 2、 操作数栈<br>
 * 局部变量表用于存储数据，而对于数据的操作（算数运算），则需要使用操作数栈，通过入栈出栈进行。例如进行加操作时，将已经存入栈的最顶层的2个操作数取出，
 * 进行求和，并将结果存入栈。<br>
 * 3、 动态链接<br>
 * 主要是为了支持运行时才进行的关联的引用，例如支持多态性，而指向运行时常量池的引用。 4、 方法返回地址<br>
 * 用于在方法执行完毕或者遇到异常需要返回时，给出外部函数的PC地址。并存储一些恢复外部函数继续执行时的必要信息。
 * 
 * @author OuYangGuoDong 2015年8月12日-下午8:28:42
 */
public class Test
{
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			final int index = i;
			new Thread(new Runnable()
			{
				
				@Override
				public void run()
				{
					ThreadDemo1.haha("xxx", index);
				}
			}).start();
		}
	}
}

class ThreadDemo1
{
	
	public static void haha(String name, int i)
	{
		System.out.println(name + "-a-" + i + Thread.currentThread().getName()
				+ " " + name.hashCode());
		name = name + "" + i;
		System.out.println(name);
		if (i % 2 == 0)
		{
			for (int j = 0; j < 10000000; j++)
			{
				System.out.print("");
			}
		}
		System.out.println(name + "-b-" + i + Thread.currentThread().getName()
				+ " " + name.hashCode());
	}
	
}
