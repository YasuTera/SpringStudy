package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
			//c トランザクション開始
			session.beginTransaction();
			
			//c DBより指定IDの取得
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			//c コースの作成
			Course course1 = new Course("Info");
			Course course2 = new Course("Network");
			Course course3 = new Course("Programming C");
			
			//DBにデータ追加 Instructor クラス経由
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);
			
			//save
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
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
