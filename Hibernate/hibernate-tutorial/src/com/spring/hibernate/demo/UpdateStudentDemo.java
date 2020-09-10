package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			//update student id
			
			//c 新しいセッションの取得　
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n生徒情報取得 生徒ID: " + studentId);
			
			Student testStudent = session.get(Student.class, studentId);
			testStudent.setFirstName("Scooby");
			System.out.println("生徒情報の更新が完了しました: ");
			
			//commit
			session.getTransaction().commit();
			
			//c 新たなセッション取得
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//emailアドレス更新
			System.out.println("生徒情報のemailアドレス更新");
			
			session.createQuery("update Student set email='foo@beruf.com'").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

}
