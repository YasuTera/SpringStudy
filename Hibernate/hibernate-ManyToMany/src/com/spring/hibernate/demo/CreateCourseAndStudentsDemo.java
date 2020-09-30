package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	//c テーブルデータ追加処理
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class) //c 追加 OneToMany
					.addAnnotatedClass(Student.class) //c 追加　ManyToMany
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c オブジェクト生成	
			
			//c トランザクション開始
			session.beginTransaction();
			

			//c コース作成
			Course tempCourse = new Course("Information Basics");
			
			//session保存
			System.out.println("----情報を保存しています----");
			session.save(tempCourse);
			System.out.println("対象コース情報に保存しました");
			
			//c 生徒情報作成
			Student testStudent = new Student("Ichitaro", "Beruf", "Ichitaro@Beruf.com");
			Student testStudent2 = new Student("Jiro", "Beruf", "Jiro@Beruf.com");
			Student testStudent3 = new Student("Saburo", "Beruf", "Saburo@Beruf.com");
			
			//c コース受講生徒情報追加
			tempCourse.addStudent(testStudent);
			tempCourse.addStudent(testStudent2);
			tempCourse.addStudent(testStudent3);
			
			//c 生徒情報保存
			System.out.println("追加情報を保存しています...");
			session.save(testStudent);
			session.save(testStudent2);
			session.save(testStudent3);
			
			System.out.println("追加しました。" + tempCourse.getStudents());
			
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
