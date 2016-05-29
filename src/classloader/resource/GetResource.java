package classloader.resource;

import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

public class GetResource
{
	
	public static void main(String[] args)
		throws Exception
	{
		/*
		 * path不以’/'开头时，默认是从此类所在的包下取资源； path 以’/'开头时，则是从ClassPath根下获取；
		 */
		System.out.println(GetResource.class.getResource(""));
		System.out.println(GetResource.class.getResource("/"));
		/*
		 * getClassLoader().getResource中path不能以’/'开头； path是从ClassPath根下获取；
		 */
		ClassLoader loader = GetResource.class.getClassLoader();
		System.out.println(loader.getResource(""));
		System.out.println(loader.getResource("/"));
		Enumeration<URL> enumeration = GetResource.class.getClassLoader()
				.getResources("");
		while (enumeration.hasMoreElements())
		{
			URL url = (URL) enumeration.nextElement();
			URLConnection connection = url.openConnection();
			System.out.println(url);
		}
	}
}
