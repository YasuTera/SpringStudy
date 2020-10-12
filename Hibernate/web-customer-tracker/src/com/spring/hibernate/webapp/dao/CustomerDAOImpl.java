package com.spring.hibernate.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.hibernate.webapp.entity.Customer;

@Repository
public class CustomerDAOImpl implements customerDAO {

	//.xml�t�@�C���Q�Ɓ@beans
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//get sessions
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c �N�G������
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//get
		List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

}
