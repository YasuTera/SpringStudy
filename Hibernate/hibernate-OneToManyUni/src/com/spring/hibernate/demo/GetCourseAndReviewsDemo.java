package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	//c テーブルデータ追加処理
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class) //c 追加
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c オブジェクト生成	
			
			//c トランザクション開始
			session.beginTransaction();
			

			//c　指定IDのコース取得
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			//c　コース表示
			System.out.println(tempCourse);
			
			//c　指定IDに沿ったレビュー一覧取得
			System.out.println(tempCourse.getReviews());
			
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
