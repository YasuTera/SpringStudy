package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		//spring config読込
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean情報取得
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		
		//c 検索処理
		List<Account> listAcc = aDao.findAccounts();
		
		//c 英字大文字のアカウント名取得
		System.out.println("\n\nMainメソッド : AfterReturningDemoAppクラスより\n----");
		System.out.println(listAcc + "\n");
		
		//close
		context.close();
	}

}
