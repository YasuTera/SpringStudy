package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			

			//c コース作成
			Course tempCourse = new Course("Information Basics");
			
			// c レビュー追加
			tempCourse.addReview(new Review("So Nice"));
			tempCourse.addReview(new Review("Detailed Course"));
			tempCourse.addReview(new Review("Thanks a lot"));
			
			
			System.out.println("コースレビュー情報を保存しています...");
			System.out.println(tempCourse + "\n" + tempCourse.getReviews());
			
			//session保存
			session.save(tempCourse);
			
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
