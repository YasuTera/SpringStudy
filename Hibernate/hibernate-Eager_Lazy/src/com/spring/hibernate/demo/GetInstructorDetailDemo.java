package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			//c トランザクション開始
			session.beginTransaction();
			
			//InstructorDetailオブジェクト取得
			int testId = 23;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, testId);
			
			//print 
			System.out.println("InstructorDetail data:　" + tempInstructorDetail);
			System.out.println("インストラクター詳細情報取得: " + tempInstructorDetail.getInstructor());
			
			//commit
			session.getTransaction().commit();
			System.out.println("処理終了");
			
		}catch(Exception e){
			e.printStackTrace();
		
		}finally {
			
			//session close
			session.close();
			
			factory.close();
		}

	}

}
