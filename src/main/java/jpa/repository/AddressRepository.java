package jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jpa.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long>
{
	List<Address> findAddress();
}
