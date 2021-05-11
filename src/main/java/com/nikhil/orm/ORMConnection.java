package com.nikhil.orm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.model.Customer;


public class ORMConnection {
	
	public interface CustomerRepository extends JpaRepository<Customer, Integer> {
		

		List<Customer> findById(int id);
		

	}

}
