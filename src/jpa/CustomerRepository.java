package jpa;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
