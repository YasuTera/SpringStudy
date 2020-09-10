package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			//c 生徒情報　id=1　の削除
			//System.out.println("生徒情報削除: " + testStudent);
			//session.delete(testStudent);
			
			//c　生徒情報　id=2　の削除
			System.out.println("生徒情報 id=2　の生徒削除");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			
			
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

}
