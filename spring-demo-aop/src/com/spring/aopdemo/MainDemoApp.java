package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//spring config“Ç
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account beanî•ñæ“¾
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		aDao.doWork();
		
		//Membership Beanî•ñæ“¾
		MembershipDAO mDao = context.getBean("membershipDAO",MembershipDAO.class);
		mDao.goToSleep();
		
		
		Account mAcc = new Account();
		//c ŒÄ‚Ño‚µ
		aDao.addAccount(mAcc, true);
		mDao.addSomething();
		
		//close
		context.close();

	}

}
