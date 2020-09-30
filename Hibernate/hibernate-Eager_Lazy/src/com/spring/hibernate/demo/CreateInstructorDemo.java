package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	//c テーブルデータ追加処理
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c オブジェクト生成
			
			Instructor tempInstructor = new Instructor("Beruf", "Office", "officeof@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("beruf.xyz", "Open"); 
			
			//c オブジェクト統合
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//c トランザクション開始
			session.beginTransaction();
			
			//annotation save DB 詳細まですべてDBに保存　CascadeType.ALLより
			System.out.println("作成情報を保存しています..." + tempInstructor);
			session.save(tempInstructor);
			
			//commit
			session.getTransaction().commit();
			System.out.println("処理終了");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}

	}

}
