package classloader;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class TestLoader
{
	
	public static void main(String[] args)
	{
		// urlLoader();
		System.out.println(TestLoader.class.getClassLoader().getResource("/"));
	}
	
	static void urlLoader()
	{
		try
		{
			URL url;
			url = new URL("file:" + "D:\\");
			ClassLoader loader = new URLClassLoader(new URL[] { url });
			Class<?> class1 = loader.loadClass("LoaderTest");
			Object obj1 = class1.newInstance();
			Method setSampleMethod = class1.getMethod("sayHello");
			setSampleMethod.invoke(obj1);
		}
		catch (Exception e1)
		{
			e1.printStackTrace();
		}
	}
}
