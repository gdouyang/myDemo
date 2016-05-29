package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyDemo {
	public static void main(String[] args) {
		HelloInterface proxy =  (HelloInterface) Proxy.newProxyInstance(
				HelloInterface.class.getClassLoader(),
				new Class[]{HelloInterface.class}, 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method,
							Object[] args) throws Throwable {
						System.out.println("aaa");
						HelloProxy target = new HelloProxy();
						Object value = method.invoke(target, args);
						return value;
					}
				});
		System.out.println(proxy.toString());
		System.out.println(proxy.getClass().getName());
		proxy.sayHello();
	}
}
