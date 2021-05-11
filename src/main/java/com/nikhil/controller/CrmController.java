package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.model.Customer;
import com.nikhil.orm.ORMConnection.CustomerRepository;
import com.nikhil.service.CustomerServiceImplementation;

@RestController
public class CrmController {
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	CustomerServiceImplementation service;
	
	@GetMapping("/showCustomers")
	public List<Customer> showCustomers() {
		
		//List<Customer> list = repository.findAll();

		List<Customer> list = service.getCustomerList();
		
		/*for(int i=0; i<list.size(); i++) {
		Customer currentItem = list.get(i);
		list.add(currentItem);
		}*/
		
		return list;
		
	}
	
	@PostMapping("/addCustomers")
	public Customer addCustomers(@RequestBody Customer customer) {
		repository.save(customer);
		return customer;
		
	}
	
	@RequestMapping("/saveCustomers")
	public String saveCustomers(@RequestBody Customer customer) {
		//repository.save(customer);
		service.saveCustomer(customer);
		return "HomePage.jsp";
	}
	
	@PutMapping("/updateCustomers")
	public List<Customer> updateCustomers(@RequestBody Customer customer) {
		repository.save(customer);
		int id = customer.getId();
		List<Customer> updatedCustomerList = service.updateCustomerList(id);
		return updatedCustomerList;
	}
	
	@DeleteMapping("/deleteCustomers/{id}")
	public String deleteCustomers(@PathVariable int id) {
		//Customer customer = repository.getOne(id);
		//repository.delete(customer);
		service.deleteCustomer(id);
		return "deleted";
	}

}
