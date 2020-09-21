package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	//c �e�[�u���f�[�^�ǉ�����
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c �I�u�W�F�N�g����
			
			Instructor tempInstructor = new Instructor("Beruf", "Office", "officeof@beruf.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("beruf.xyz", "Open"); 
			
			//c �I�u�W�F�N�g����
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//annotation save DB �ڍׂ܂ł��ׂ�DB�ɕۑ��@CascadeType.ALL���
			System.out.println("�쐬����ۑ����Ă��܂�..." + tempInstructor);
			session.save(tempInstructor);
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}finally {
			// add clean up code
			session.close();
			
			factory.close();
		}

	}

}
