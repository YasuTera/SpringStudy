package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean���擾
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		aDao.doWork();
		
		//getter setter�@�l����
		aDao.setName("foo");
		aDao.setServiceCode("silver");
		
		String name = aDao.getName();
		String code = aDao.getServiceCode();
		
		
		//Membership Bean���擾
		MembershipDAO mDao = context.getBean("membershipDAO",MembershipDAO.class);
		mDao.goToSleep();
		
		
		Account mAcc = new Account();
		//c �Ăяo��
		aDao.addAccount(mAcc, true);
		mDao.addSomething();
		
		//close
		context.close();

	}

}
