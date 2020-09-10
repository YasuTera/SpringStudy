package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Student;

public class CreateDemo {

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
			//c �I�u�W�F�N�g����
			/*
			Instructor tempInstructor = new Instructor("Beruf", "Integra", "test@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://home4.beruf.xyz/", "Teaching"); 
			*/
			
			Instructor tempInstructor = new Instructor("Beruf", "AnotherIntegra", "other@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://home3.beruf.xyz/", "Resting"); 
			
			//c �I�u�W�F�N�g����
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//annotation save DB �ڍׂ܂ł��ׂ�DB�ɕۑ��@CascadeType.ALL���
			System.out.println("�C���X�g���N�^�[����ۑ����Ă��܂�..." + tempInstructor);
			session.save(tempInstructor);
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
