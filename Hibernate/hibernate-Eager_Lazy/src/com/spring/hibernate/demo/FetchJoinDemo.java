package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
				
				//Hibernate HQL�L�q
				//c DB���w��ID�̎擾
				int theId = 1;
				
				Query<Instructor> query = session.createQuery("select i from Instructor i " 
																+ "JOIN FETCH i.courses " 
																+ "where i.id=:theInstructorId", Instructor.class);
				
				//set parameter
				query.setParameter("theInstructorId", theId);
				
				//execute / �l�擾
				Instructor tempInstructor = query.getSingleResult();
				
				System.out.println("beruf: Instructor: " + tempInstructor);
				
				
				//commit
				session.getTransaction().commit();
				
				//close session
				session.close();
				
				System.out.println("session�I��");

				
				
				//c InstructorID�ɕR�Â����R�[�X�擾
				System.out.println("Beruf: Courses: " + tempInstructor.getCourses());
				
				System.out.println("�����I��");
				
			}finally {
				// add clean up code
				session.close();
				
				factory.close();
			}

		}

}
