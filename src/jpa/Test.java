package jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");
//		context.
		CustomerRepository repository = context.getBean(CustomerRepository.class);
		
		repository.save(new Customer("欧阳", "国栋"));
	}
}
