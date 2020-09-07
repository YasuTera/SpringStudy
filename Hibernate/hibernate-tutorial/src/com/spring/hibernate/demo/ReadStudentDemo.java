package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//c �Z�b�V�������p�I�u�W�F�N�g����
			System.out.println("���k���̎擾�����Ă��܂�...");
			Student tempStudent = new Student("Duff", "Duck", "duff@beruf.com");
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//save student object
			System.out.println("���k��o�^���Ă��܂�...");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			//commit
			session.getTransaction().commit();
			
			
			//search student id
			//find
			System.out.println("���k�̓o�^���������܂����B �������ꂽ���ID: " + tempStudent.getId());
			
			//c �V�����Z�b�V�����̎擾�@
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n���k���擾 ���kID: " + tempStudent.getId());
			
			Student testStudent = session.get(Student.class, tempStudent.getId());
			System.out.println("���k���̎擾���������܂���: " + testStudent);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
