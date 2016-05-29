package ji_cheng;

public class Father {
	public int age = 30;
	
	public Father(){
		System.out.println("Father  的构造方法");
	}
	
	public void getAge(){
		System.out.println("father's Age: " + age);
	}
  public void sayHello(){
	  System.out.println("Father say Hello!!");
	  invokeSayHello();
  }
  
  public void invokeSayHello(){
  }
}
