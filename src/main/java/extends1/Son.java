package extends1;

public class Son extends Father{
	public int age = 10;
	
	public Son(){
		System.out.println("Son 的构造方法");
	}
	
	public void getAge(){
		System.out.println("son's Age: " + age);
	}
//  public void sayHello(){
//	  System.out.println("Son say Hello");
//  }
	 public void invokeSayHello(){
		 System.out.println("son's invokeSayHello Method");
	  }
}
