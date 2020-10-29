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
		
		//c DB登録(insert or update 一意キーがない場合とある場合での動作分岐関数)
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//hibernate セッション取得
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c 一意キーより結びついたデータ取得
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		//hibernate セッション取得
		Session currentSession = sessionFactory.getCurrentSession();
		
		//c 一意キーに紐づく顧客情報の削除
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomers(String searchName) {
		
		//Hibernate セッション取得
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		
		//c 検索フォームに入力されているならばTrue　--入力チェック--
		if(searchName != null && searchName.trim().length() > 0) {
			
			//c　英字をすべて小文字に変換して検索処理
			theQuery = currentSession.createQuery("from Customer where lower(firstName) like :tName or lower(lastName) like :tName", Customer.class);
			theQuery.setParameter("tName", "%"+"searchName.toLowerCase()"+ "%");
			
		}else {
			//c 検索フォームに入力が何もないFalse状態のとき　すべての顧客情報取得
			theQuery = currentSession.createQuery("from Customer", Customer.class);
		}
		
		//c 処理結果の受け渡し
		List<Customer> customer = theQuery.getResultList();
		
		return customer;
	}

}
