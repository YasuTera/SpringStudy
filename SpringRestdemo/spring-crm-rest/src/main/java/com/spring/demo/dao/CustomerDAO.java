package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.entity.Customer;

//CRUD interface
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
