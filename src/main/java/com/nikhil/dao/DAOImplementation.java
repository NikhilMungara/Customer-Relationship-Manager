package com.nikhil.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nikhil.controller.CrmController;
import com.nikhil.model.Customer;
import com.nikhil.orm.ORMConnection.CustomerRepository;

@Component
@Transactional
public class DAOImplementation implements DAOInterface{

	@Autowired
	CustomerRepository repository;
	Customer model;
	CrmController controller;

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
	Session session;
	public Session getSession() {
		return session;
	}
	
	String hql = "select * from Customer";
	Query query = session.createQuery(hql);
	List result = query.list();
}
