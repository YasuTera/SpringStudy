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
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//c �o�^���ꂽ�C���X�g���N�^�[�̈��ID�擾
			int testId = 1;
			Instructor tempInstructor = session.get(Instructor.class, testId);
			
			//c �C���X�g���N�^�[���폜
			System.out.println("�C���X�g���N�^�[�����擾..." + tempInstructor);
			if(tempInstructor != null) {
				System.out.println("�폜: " + tempInstructor);
				
				//c ��ID�C���X�g���N�^�[���ڍׁ@InstructorDetail���R�[�h���폜����� CascadeType.ALL���
				session.delete(tempInstructor);
			}
			
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
