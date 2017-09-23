package proxy.aop;



public class TestMyInject {
	public static void main(String[] args) {
		//HelloInject h = (HelloInject) MyInjectEngine.getProxy(new HelloInjectImpl());
		MyInjectInvocationHandler handler = new MyInjectInvocationHandler();
		HelloInject h = (HelloInject)handler.getProxy(new HelloInjectImpl());
		System.out.println(h);
		h.sayHello();
	}
}
