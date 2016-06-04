package jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jpa.entity.Address;
import jpa.entity.Customer;
import jpa.repository.AddressRepository;
import jpa.repository.CustomerRepository;

public class Test2
{
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/application.xml");
		CustomerRepository cusRep = context
				.getBean(CustomerRepository.class);
		AddressRepository addRep = context.getBean(AddressRepository.class);
		Address a = new Address(1L, "地址");
		addRep.save(a);
		
		Customer customer = new Customer("欧阳", "国栋");
		customer.setAddress(a);
		cusRep.save(customer);
		List<Customer> ls = cusRep.findByFirstName("欧阳");
		for (Customer c : ls)
		{
			System.out.println(c);
		}
		System.exit(0);
	}
}
