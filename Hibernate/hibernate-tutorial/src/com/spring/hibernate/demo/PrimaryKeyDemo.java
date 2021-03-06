package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
			
			//create session factory
			SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
			
			//create session
			Session session = factory.getCurrentSession();
			
			try {
				//c セッション利用オブジェクト生成 SQL登録
				System.out.println("生徒情報の取得をしています...");
				Student tempStudent1 = new Student("John", "Doe", "john@beruf.com");
				Student tempStudent2 = new Student("Mary", "Public", "mary@beruf.com");
				Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@beruf.com");
				
				//c トランザクション開始
				session.beginTransaction();
				
				//save student object
				System.out.println("生徒を登録しています...");
				session.save(tempStudent1);
				session.save(tempStudent2);
				session.save(tempStudent3);
				
				//commit
				session.getTransaction().commit();
				System.out.println("処理終了");
				
			}finally {
				factory.close();
			}
	}

}
