package jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("/application.xml");
//		context.
		CustomerRepository repository = context.getBean(CustomerRepository.class);
		
		//repository.save(new Customer("欧阳", "国栋"));
		List<Customer> ls = repository.findByFirstName("欧阳");
		for (Customer customer : ls)
		{
			System.out.println(customer);
		}
		Iterable<Customer> list = repository.findAll();
		for (Customer customer : list)
		{
			System.out.println(customer);
		}
		EntityManager em = context.getBean(EntityManager.class);
		//
		List<Customer> customers = em.createNamedQuery("findAllCustomersWithName")
	            .setParameter("custName", "欧阳")
	            .getResultList();
		System.out.println(customers.size());
		customers = em.createNamedQuery("findAllCustomersWithNameNative")
				.setParameter("custName", "欧阳")
				.getResultList();
		System.out.println(customers.size());
		System.exit(0);
	}
}
