package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c セッション利用オブジェクト生成
			System.out.println("生徒情報の取得をしています...");
			Student tempStudent = new Student("Duff", "Duck", "duff@beruf.com");
			
			//c トランザクション開始
			session.beginTransaction();
			
			//save student object
			System.out.println("生徒を登録しています...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit
			session.getTransaction().commit();
			
			
			//search student id
			//find
			System.out.println("生徒の登録が完了しました。 生成された一意ID: " + tempStudent.getId());
			
			//c 新しいセッションの取得　
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n生徒情報取得 生徒ID: " + tempStudent.getId());
			
			Student testStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("生徒情報の取得が完了しました: " + testStudent);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

}
