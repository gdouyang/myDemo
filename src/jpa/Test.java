package jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jpa.entity.Address;
import jpa.entity.Customer;
import jpa.repository.AddressRepository;
import jpa.repository.CustomerRepository;

public class Test
{
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/application.xml");
		// context.
		CustomerRepository repository = context
				.getBean(CustomerRepository.class);
				
		// repository.save(new Customer("欧阳", "国栋"));
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
		String custName = "欧阳";
		List<Customer> customers = repository.findAllCustomersWithName(custName);
				//em.createNamedQuery("findAllCustomersWithName").setParameter("custName", "欧阳").getResultList();
		//System.out.println(customers.size());
		//customers = repository.findAllCustomersWithNameNative(custName);
				//em.createNamedQuery("findAllCustomersWithNameNative").setParameter("custName", "欧阳").getResultList();
		//System.out.println(customers.size());
		
		AddressRepository addressRepository = context.getBean(AddressRepository.class);
		//addressRepository.save(new Address(1L, "地址"));
		System.out.println(addressRepository.findAddress());
		System.exit(0);
	}
}
