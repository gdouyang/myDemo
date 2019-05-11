package generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Test {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Generic generic = new Generic<>();
		Generic<String> g1 = generic;
		g1.setKey("0");
		System.out.println(g1.getClass().getGenericSuperclass());
		System.out.println(g1.getClass().getTypeParameters()[0]);
		TypeVariable<?>[] typeParameters = g1.getClass().getTypeParameters();
		for (TypeVariable<?> typeVariable : typeParameters) {
			System.out.println(typeVariable.getName());
			System.out.println(typeVariable.getTypeName());
			System.out.println(typeVariable.getBounds());
		}
		Type[] genericInterfaces = g1.getClass().getGenericInterfaces();
		System.out.println(g1.getKey());
		Generic<Integer> g2 = generic;
		g2.setKey(1);
		Method method = g2.getClass().getMethod("setKey", Object.class);
		method.invoke(g2, "aaa");
		System.out.println(g2.getKey());
		
	}
}
