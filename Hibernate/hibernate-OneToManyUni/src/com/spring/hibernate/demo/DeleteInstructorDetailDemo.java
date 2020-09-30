package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

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
			
			//InstructorDetail�I�u�W�F�N�g�擾
			int testId = 3;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, testId);
			
			//print 
			System.out.println("InstructorDetail data:�@" + tempInstructorDetail);
			System.out.println("�C���X�g���N�^�[�ڍ׏��擾: " + tempInstructorDetail.getInstructor());
			
			//c �폜����
			System.out.println("�폜����: " + tempInstructorDetail);
			
			//c �I�u�W�F�N�g��ForeignKey������ԉ��� instructor�e�[�u���@instructor_detail_id��null��
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}catch(Exception e){
			e.printStackTrace();
		
		}finally {
			
			//session close
			session.close();
			
			factory.close();
		}

	}

}
