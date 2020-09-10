package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			//c 登録されたインストラクターの一意ID取得
			int testId = 1;
			Instructor tempInstructor = session.get(Instructor.class, testId);
			
			//c インストラクター情報削除
			System.out.println("インストラクター情報を取得..." + tempInstructor);
			if(tempInstructor != null) {
				System.out.println("削除: " + tempInstructor);
				
				//c 同IDインストラクター情報詳細　InstructorDetailレコードも削除される CascadeType.ALLより
				session.delete(tempInstructor);
			}
			
			
			//commit
			session.getTransaction().commit();
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

}
