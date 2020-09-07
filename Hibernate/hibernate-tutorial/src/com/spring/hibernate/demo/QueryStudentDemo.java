package com.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//c トランザクション開始
			session.beginTransaction();
			
			//c　生徒情報クエリ生成
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//c 配列から生徒情報取得 表示
			displayStudents(students);
			
			//c クエリから苗字がDoeの生徒を取得 ※クエリに指定するのはテーブルカラム名ではない
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//c 苗字Doeの生徒取得
			System.out.println("Doeと苗字に入っている生徒");
			displayStudents(students);
			
			
			//c 苗字Doe または 名前がDuff の生徒
			students 
				= session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Duff'").getResultList();
			
			System.out.println("Doeが苗字に、またはDuffが名前に入っている生徒");
			displayStudents(students);
			
			
			//emailがberuf.と入力されている生徒
			students = session.createQuery("from Student s where s.email LIKE '%beruf.%'").getResultList();
			System.out.println("emailにberuf.と入力されている生徒");
			displayStudents(students);
			
			//commit
			session.getTransaction().commit();
			System.out.println("処理終了");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
		}
	}

}
