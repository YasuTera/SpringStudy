package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
				
				System.out.println("beruf: Instructor: " + tempInstructor);
				
				//sessionが開いたまま
				System.out.println("Beruf: Courses: " + tempInstructor.getCourses());
				
				//commit
				session.getTransaction().commit();
				
				//close session
				session.close();
				
				System.out.println("session終了");
				//getter呼出(sessionが開始されている間)
				
				//c InstructorIDに紐づいたコース取得
				System.out.println("Beruf: Courses: " + tempInstructor.getCourses());
				
				System.out.println("処理終了");
				
			}finally {
				// add clean up code
				session.close();
				
				factory.close();
			}

		}

}
