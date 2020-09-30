package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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
				
				//c　削除したいコースID取得
				int theId = 1;
				Course dCourse = session.get(Course.class, theId);
				
				//c コース削除
				System.out.println("対象のコースを削除しています: " + dCourse);
				
				session.delete(dCourse);
				
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
