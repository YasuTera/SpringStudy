package com.spring.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class)
					.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			//c �g�����U�N�V�����J�n
			session.beginTransaction();
			
			//c�@���k���N�G������
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//c �z�񂩂琶�k���擾 �\��
			displayStudents(students);
			
			//c �N�G������c����Doe�̐��k���擾 ���N�G���Ɏw�肷��̂̓e�[�u���J�������ł͂Ȃ�
			students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			//c �c��Doe�̐��k�擾
			System.out.println("Doe�ƕc���ɓ����Ă��鐶�k");
			displayStudents(students);
			
			
			//c �c��Doe �܂��� ���O��Duff �̐��k
			students 
				= session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Duff'").getResultList();
			
			System.out.println("Doe���c���ɁA�܂���Duff�����O�ɓ����Ă��鐶�k");
			displayStudents(students);
			
			
			//email��beruf.�Ɠ��͂���Ă��鐶�k
			students = session.createQuery("from Student s where s.email LIKE '%beruf.%'").getResultList();
			System.out.println("email��beruf.�Ɠ��͂���Ă��鐶�k");
			displayStudents(students);
			
			//commit
			session.getTransaction().commit();
			System.out.println("�����I��");
			
		}finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
		}
	}

}
