package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
				
				//c �g�����U�N�V�����J�n
				session.beginTransaction();
				
				//c DB���w��ID�̎擾
				int theId = 1;
				Instructor tempInstructor = session.get(Instructor.class, theId);
				
				System.out.println("Instructor: " + tempInstructor);
				
				//c InstructorID�ɕR�Â����R�[�X�擾
				System.out.println("Courses: " + tempInstructor.getCourses());
				
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