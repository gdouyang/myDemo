package proxy.aop;

public class HelloInjectImpl implements HelloInject {

	@Override
	@MyInject
	public void sayHello() {
		System.out.println("hello Inject!!");
	}

}
