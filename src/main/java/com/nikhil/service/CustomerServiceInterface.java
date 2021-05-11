package com.nikhil.service;

import java.util.List;

import com.nikhil.model.Customer;

public interface CustomerServiceInterface {
	
	public abstract List<Customer> getCustomerList();
	public abstract Customer saveCustomer(Customer customer);
	public abstract List<Customer> updateCustomerList(int id);
	public abstract void deleteCustomer(int id);

}
