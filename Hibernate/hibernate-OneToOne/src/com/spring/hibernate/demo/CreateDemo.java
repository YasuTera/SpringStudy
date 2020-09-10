package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c オブジェクト生成
			/*
			Instructor tempInstructor = new Instructor("Beruf", "Integra", "test@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://home4.beruf.xyz/", "Teaching"); 
			*/
			
			Instructor tempInstructor = new Instructor("Beruf", "AnotherIntegra", "other@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://home3.beruf.xyz/", "Resting"); 
			
			//c オブジェクト統合
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//c トランザクション開始
			session.beginTransaction();
			
			//annotation save DB 詳細まですべてDBに保存　CascadeType.ALLより
			System.out.println("インストラクター情報を保存しています..." + tempInstructor);
			session.save(tempInstructor);
			
			//commit
			session.getTransaction().commit();
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

}
