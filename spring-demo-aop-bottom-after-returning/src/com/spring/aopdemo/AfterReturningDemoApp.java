package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean���擾
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		
		//c ��������
		List<Account> listAcc = aDao.findAccounts();
		
		//c �p���啶���̃A�J�E���g���擾
		System.out.println("\n\nMain���\�b�h : AfterReturningDemoApp�N���X���\n----");
		System.out.println(listAcc + "\n");
		
		//close
		context.close();
	}

}
