package proxy.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInjectInvocationHandler implements InvocationHandler {
	private Object target = null;

	public MyInjectInvocationHandler() {
	}

	public MyInjectInvocationHandler(Object target) {
		this.target = target;
	}

	public Object getProxy(Object target) {
		if (target != null) {
			this.target = target;
			Class<? extends Object> clazz = target.getClass();
			// 得到类中的所有方法
			Method[] methods = clazz.getMethods();
			for (Method m : methods) {
				// 如果指定类型的注释存在于此元素上，则返回 true，否则返回 false。
				if (m.isAnnotationPresent(MyInject.class)) {
					return Proxy.newProxyInstance(clazz.getClassLoader(),
							clazz.getInterfaces(), this);
				}
			}
		}
		return null;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object value = null;
		if (target.getClass().getMethod(method.getName()).isAnnotationPresent(MyInject.class)) {
			System.out.println(method.getName() + "代理类执行方法前");
			value = method.invoke(target, args);
			System.out.println(method.getName() + "代理类执行方法后");
		}else{
			value = method.invoke(target, args);
		}
		return value;
	}

}
