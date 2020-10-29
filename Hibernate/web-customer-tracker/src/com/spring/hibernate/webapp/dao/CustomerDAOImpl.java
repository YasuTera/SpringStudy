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
		
		//c DB�o�^(insert or update ��ӃL�[���Ȃ��ꍇ�Ƃ���ꍇ�ł̓��앪��֐�)
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//hibernate �Z�b�V�����擾
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c ��ӃL�[��茋�т����f�[�^�擾
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//hibernate �Z�b�V�����擾
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c ��ӃL�[�ɕR�Â��ڋq���̍폜
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		
		//Hibernate �Z�b�V�����擾
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		//c �����t�H�[���ɓ��͂���Ă���Ȃ��True�@--���̓`�F�b�N--
		if(searchName != null && searchName.trim().length() > 0) {
			
			//c�@�p�������ׂď������ɕϊ����Č�������
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :tName or lower(lastName) like :tName", Customer.class);
			theQuery.setParameter("tName", "%"+"searchName.toLowerCase()"+ "%");
			
		}else {
			//c �����t�H�[���ɓ��͂������Ȃ�False��Ԃ̂Ƃ��@���ׂĂ̌ڋq���擾
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		//c �������ʂ̎󂯓n��
		List<Customer> customer = theQuery.getResultList();
		
		return customer;
	}

}
