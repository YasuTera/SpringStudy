package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

	//c �e�[�u���f�[�^�ǉ�����
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Instructor.class)
					.addAnnotatedClass(InstructorDetail.class)
					.addAnnotatedClass(Course.class)
					.addAnnotatedClass(Review.class) //c �ǉ�
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c �I�u�W�F�N�g����	
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			

			//c �R�[�X�쐬
			Course tempCourse = new Course("Information Basics");
			
			// c ���r���[�ǉ�
			tempCourse.addReview(new Review("So Nice"));
			tempCourse.addReview(new Review("Detailed Course"));
			tempCourse.addReview(new Review("Thanks a lot"));
			
			
			System.out.println("�R�[�X���r���[����ۑ����Ă��܂�...");
			System.out.println(tempCourse + "\n" + tempCourse.getReviews());
			
			//session�ۑ�
			session.save(tempCourse);
			
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
