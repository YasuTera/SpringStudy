package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		//spring config読込
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean情報取得
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		
		//c 例外処理
		List<Account> listAcc = null;
		try {
			// flag 検証用
			boolean trW = false;
			
			listAcc = aDao.findAccounts(trW);
		}
		catch(Exception e) {
			//c 最初にMyDemoLoggingAspect.afterThrowingFindAccountsAdvice(Joinpoint,Exception)内部でエラーを出力後、Java本体から同エラー出力
			System.out.println("\n\n エラーです: " + e);
		}
		
		//c 英字大文字のアカウント名取得
		System.out.println("\n\nMainメソッド : AfterThrowingDemoAppクラスより\n----");
		System.out.println(listAcc + "\n");
		
		//close
		context.close();
	}

}
