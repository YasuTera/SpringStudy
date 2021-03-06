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
		
		//Membership Bean情報取得
				MembershipDAO mDao = context.getBean("membershipDAO",MembershipDAO.class);
		
		Account mAcc = new Account();
		mAcc.setName("Beruf");
		mAcc.setLevel("Platinum");
		
		//c 受け渡し
		aDao.addAccount(mAcc, true);
		aDao.doWork();
		
		//getter setter　値入れ
		aDao.setName("foo");
		aDao.setServiceCode("silver");
		
		String name = aDao.getName();
		String code = aDao.getServiceCode();
		
		mDao.addSomething();
		mDao.goToSleep();
		
		//close
		context.close();

	}

}
