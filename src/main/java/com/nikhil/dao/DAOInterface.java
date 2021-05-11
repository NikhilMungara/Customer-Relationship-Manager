package com.nikhil.dao;

import java.util.List;

import com.nikhil.model.Customer;

public interface DAOInterface {
	public abstract List<Customer> getCustomerList();
	public abstract Customer saveCustomer(Customer customer);
	public abstract List<Customer> updateCustomerList(int id);
	public abstract void deleteCustomer(int id);
}
