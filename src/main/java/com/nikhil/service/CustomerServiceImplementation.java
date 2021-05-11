package com.nikhil.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nikhil.controller.CrmController;
import com.nikhil.dao.DAOImplementation;
import com.nikhil.model.Customer;
import com.nikhil.orm.ORMConnection.CustomerRepository;

@Transactional
@Service
public class CustomerServiceImplementation implements CustomerServiceInterface {
	
	@Autowired
	CustomerRepository repository;
	Customer model;
	CrmController controller;
	DAOImplementation dao;

	@Override
	public List<Customer> getCustomerList() {
		List<Customer> list = repository.findAll();
		return list;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		repository.save(customer);
		return customer;
	}

	@Override
	public List<Customer> updateCustomerList(int id) {
		List<Customer> list = repository.findAll();
		for(int i = id; i<list.size();i++) {
			Customer customer = list.get(i);
			list.add(customer);
		}
		return list;
	}

	@Override
	public void deleteCustomer(int id) {
		Customer customer = repository.getOne(id);
		repository.delete(customer);
		
	}
	
	

}
