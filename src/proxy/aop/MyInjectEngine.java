package proxy.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * MyInject引擎专门处理MyInject注解
 * @author snake
 *
 */
public class MyInjectEngine {
	public static Object getProxy(Object obj) {
		if (obj != null) {
			Class<? extends Object> clazz = obj.getClass();
			//得到类中的所有方法
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				// 如果指定类型的注释存在于此元素上，则返回 true，否则返回 false。
				if (m.isAnnotationPresent(MyInject.class)) {
					return Proxy
							.newProxyInstance(clazz.getClassLoader(),
									clazz.getInterfaces(),
									new MyInjectInvocationHandler(obj));
				}
			}
		}
		return null;
	}

}
