package com.spring.hibernate.webapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.hibernate.webapp.entity.Customer;

@Repository
public class CustomerDAOImpl implements customerDAO {

	//.xml�t�@�C���Q�Ɓ@beans
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get sessions
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c �N�G������ �c���~���\�[�g
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get
		List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//session�擾
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c DB�o�^
		currentSession.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//hibernate �Z�b�V�����擾
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c ��ӃL�[��茋�т����f�[�^�擾
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

}
