package com.spring.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 1;
			//update student id
			
			//c �V�����Z�b�V�����̎擾�@
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\n���k���擾 ���kID: " + studentId);
			
			Student testStudent = session.get(Student.class, studentId);
			
			//c ���k���@id=1�@�̍폜
			//System.out.println("���k���폜: " + testStudent);
			//session.delete(testStudent);
			
			//c�@���k���@id=2�@�̍폜
			System.out.println("���k��� id=2�@�̐��k�폜");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			//commit
			session.getTransaction().commit();
			
			
			
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

}
