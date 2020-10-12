package com.spring.hibernate.webapp.dao;

import java.util.List;

import com.spring.hibernate.webapp.entity.Customer;

public interface customerDAO {

	public List<Customer> getCustomers();
}
