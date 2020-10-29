package com.spring.hibernate.webapp.dao;

import java.util.List;

import com.spring.hibernate.webapp.entity.Customer;

public interface customerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public List<Customer> searchCustomers(String searchName);
}
