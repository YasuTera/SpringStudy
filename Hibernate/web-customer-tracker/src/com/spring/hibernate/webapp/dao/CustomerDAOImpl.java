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

	//.xmlファイル参照　beans
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get sessions
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c クエリ生成 苗字降順ソート
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//get
		List<Customer> customers = theQuery.getResultList();
		
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//session取得
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c DB登録
		currentSession.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//hibernate セッション取得
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c 一意キーより結びついたデータ取得
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

}
