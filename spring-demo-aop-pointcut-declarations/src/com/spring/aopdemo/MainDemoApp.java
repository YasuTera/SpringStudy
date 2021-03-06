package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;
import com.spring.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//spring config読込
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean情報取得
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		aDao.doWork();
		
		//Membership Bean情報取得
		MembershipDAO mDao = context.getBean("membershipDAO",MembershipDAO.class);
		mDao.goToSleep();
		
		
		Account mAcc = new Account();
		//c 呼び出し
		aDao.addAccount(mAcc, true);
		mDao.addSomething();
		
		//close
		context.close();

	}

}
