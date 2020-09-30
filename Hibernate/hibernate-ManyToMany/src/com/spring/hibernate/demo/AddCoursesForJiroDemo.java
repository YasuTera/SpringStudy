package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class AddCoursesForJiroDemo {

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
			
			//Jiroの情報をDBから取得
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("生徒: " + tempStudent + "を読み込みました");
			System.out.println("選択コース: " + tempStudent.getCourses());
			
			//c 追加コース作成
			Course tempCourse = new Course("Networks + Web Application dev");
			Course tempCourse2 = new Course("Study of Statistics");
			Course tempCourse3 = new Course("Enrty of Data Scientist");
			
			//c 追加コースにJiro追加
			tempCourse.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			tempCourse3.addStudent(tempStudent);
			
			//c コース情報保存
			System.out.println("更新しています...");
			session.save(tempCourse);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
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
