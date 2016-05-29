package classloader;

import java.io.File;
import java.lang.reflect.Method;


/***
 * 测试文件系统类加载器
 * @author Snake
 *
 */
public class ClassIdentity {

	public static void main(String[] args) {
		new ClassIdentity().testClassIdentity();
	}
	
	/**
	 * 运行时抛出了 java.lang.ClassCastException异常。虽然两个对象 obj1和 obj2的类的名字相同，
	 * 但是这两个类是由不同的类加载器实例来加载的，因此不被 Java 虚拟机认为是相同的。
	 * 了解了这一点之后，就可以理解代理模式的设计动机了。代理模式是为了保证 Java 核心库的类型安全。
	 * 所有 Java 应用都至少需要引用 java.lang.Object类，也就是说在运行的时候，
	 * java.lang.Object这个类需要被加载到 Java 虚拟机中。
	 * 如果这个加载过程由 Java 应用自己的类加载器来完成的话，
	 * 很可能就存在多个版本的 java.lang.Object类，而且这些类之间是不兼容的。
	 * 通过代理模式，对于 Java 核心库的类的加载工作由引导类加载器来统一完成，
	 * 保证了 Java 应用所使用的都是同一个版本的 Java 核心库的类，是互相兼容的。
	 */
	public void testClassIdentity() {
		//String classDataRootPath = "G:\\development\\workspace_64\\classloader";
		String classDataRootPath = "G:\\development\\workspace_64\\number";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		String className = "number.NumberTest";	
		
		try {
		System.out.println("获取绝对路径  "+new File("").getAbsolutePath());//获取绝对路径 
		System.out.println("获取标准的路径  "+new File("").getCanonicalPath());//获取标准的路径 
			Class<?> class1 = fscl1.loadClass(className);
			Object obj1 = class1.newInstance();
			Class<?> class2 = fscl2.loadClass(className);
			Object obj2 = class2.newInstance();
			Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
			setSampleMethod.invoke(obj1, obj2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
