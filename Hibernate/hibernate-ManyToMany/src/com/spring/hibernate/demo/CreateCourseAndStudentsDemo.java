package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Course;
import com.spring.hibernate.demo.entity.Instructor;
import com.spring.hibernate.demo.entity.InstructorDetail;
import com.spring.hibernate.demo.entity.Review;
import com.spring.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

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
			

			//c �R�[�X�쐬
			Course tempCourse = new Course("Information Basics");
			
			//session�ۑ�
			System.out.println("----����ۑ����Ă��܂�----");
			session.save(tempCourse);
			System.out.println("�ΏۃR�[�X���ɕۑ����܂���");
			
			//c ���k���쐬
			Student testStudent = new Student("Ichitaro", "Beruf", "Ichitaro@Beruf.com");
			Student testStudent2 = new Student("Jiro", "Beruf", "Jiro@Beruf.com");
			Student testStudent3 = new Student("Saburo", "Beruf", "Saburo@Beruf.com");
			
			//c �R�[�X��u���k���ǉ�
			tempCourse.addStudent(testStudent);
			tempCourse.addStudent(testStudent2);
			tempCourse.addStudent(testStudent3);
			
			//c ���k���ۑ�
			System.out.println("�ǉ�����ۑ����Ă��܂�...");
			session.save(testStudent);
			session.save(testStudent2);
			session.save(testStudent3);
			
			System.out.println("�ǉ����܂����B" + tempCourse.getStudents());
			
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
