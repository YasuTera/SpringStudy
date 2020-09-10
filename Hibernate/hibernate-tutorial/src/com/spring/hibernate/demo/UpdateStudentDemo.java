package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			//update student id
			
			//c �V�����Z�b�V�����̎擾�@
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n���k���擾 ���kID: " + studentId);
			
			Student testStudent = session.get(Student.class, studentId);
			testStudent.setFirstName("Scooby");
			System.out.println("���k���̍X�V���������܂���: ");
			
			//commit
			session.getTransaction().commit();
			
			//c �V���ȃZ�b�V�����擾
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//email�A�h���X�X�V
			System.out.println("���k����email�A�h���X�X�V");
			
			session.createQuery("update Student set email='foo@beruf.com'").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
