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
	
	public static void main(String[] args)
	{
		query();
		//add();
		System.exit(0);
	}
	public static void query(){
		ApplicationContext context =getContext();
		CustomerRepository cusRep = context.getBean(CustomerRepository.class);
		Customer c = cusRep.findFirstByOrderByAddressAsc();
		System.out.println(c);
	}
	
	private static ApplicationContext getContext()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"/application.xml");
		return context;
	}
	
	public static void add()
	{
		ApplicationContext context = getContext();
		CustomerRepository cusRep = context.getBean(CustomerRepository.class);
		AddressRepository addRep = context.getBean(AddressRepository.class);
		Address a = new Address(3L, "地址3");
		addRep.save(a);
		
		Customer customer = new Customer("oy3", "gd3");
		customer.setAddress(a);
		cusRep.save(customer);
		List<Customer> ls = cusRep.findByFirstName("oy3");
		for (Customer c : ls)
		{
			System.out.println(c);
		}
	}
}
