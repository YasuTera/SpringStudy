package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c �Z�b�V�������p�I�u�W�F�N�g����
			System.out.println("���k���̎擾�����Ă��܂�...");
			Student tempStudent = new Student("Pail", "Wall", "paul@beruf,com");
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//save student object
			System.out.println("���k��o�^���Ă��܂�...");
			session.save(tempStudent);
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
