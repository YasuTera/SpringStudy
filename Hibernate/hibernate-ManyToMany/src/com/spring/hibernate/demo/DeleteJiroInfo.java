package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class DeleteJiroInfo {

	//c �e�[�u���f�[�^�ǉ�����
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class) //c �ǉ� OneToMany
					.addAnnotatedClass(Student.class) //c �ǉ��@ManyToMany
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c �I�u�W�F�N�g����	
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//Jiro�̏���DB����擾
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("���k: " + tempStudent + "��ǂݍ��݂܂���");
			System.out.println("�I���R�[�X: " + tempStudent.getCourses());
			
			//c �폜����
			System.out.println("���k: " + tempStudent + " ���폜���܂��B");
			session.delete(tempStudent);
			
			
			
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
