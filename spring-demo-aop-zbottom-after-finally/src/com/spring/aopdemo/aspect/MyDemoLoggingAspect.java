package com.spring.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//@After(finally) section //Spring 5.2.7より @Afterが@AfterThrowingの後に実行される仕様になった
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		
	//c どのメソッドを指定しているかの確認
	String mth = jp.getSignature().toShortString();
	System.out.println("\n=====>>> From @After(finally) method: " + mth);	
	}
	
	//@AfterThrowing section
	@AfterThrowing(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
		
		//c どのメソッドを指定しているかの確認
		String mth = jp.getSignature().toShortString();
		System.out.println("\n=====>>> From @AfterThrowing method: " + mth);
				
		//c 結果表示
		System.out.println("\n=====>>> result: " + exc);
	}
	
	//@AfterReturning section
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAdvice(JoinPoint jp, List<Account> res) {
		
		//c どのメソッドを指定しているかの確認
		String mth = jp.getSignature().toShortString();
		System.out.println("\n=====>>> From @AfterReturning method: " + mth);
		
		//c 結果表示
		System.out.println("\n=====>>> result: " + res);
		
		//c
		
		//c アカウント名を英字大文字に変換
		convertAccountNamesToUpperCase(res);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> res) {
		//loop 検索取得処理
		for(Account tmpAcc : res) {
			
			//c アカウント名を大文字に変換して取得
			String uppName = tmpAcc.getName().toUpperCase();
			
			//c 取得したものをset
			tmpAcc.setName(uppName);
		}
	}

	//c 指定メソッド前に呼び出し combineNoGetterSetter()メソッド実行前に実行
	@Before("com.spring.aopdemo.aspect.combineAopExpressions.combineNoGetterSetter()") 
	public void beforeAddAccount(JoinPoint jp) {
		
		System.out.println("=====>>> From beforeAddAccount");
		
		//c メソッドの確認
		MethodSignature ms = (MethodSignature) jp.getSignature();
		System.out.println("Method: " + ms);
		
		//c メソッド引数の確認
		//c
		Object[] oList = jp.getArgs();
		
		//loop
		for(Object tmp : oList) {
			System.out.println(tmp);
			
			//check
			if(tmp instanceof Account) {
				
				Account ac = (Account) tmp;
				System.out.println("アカウント名: " + ac.getName());
				System.out.println("レベル: " + ac.getLevel());
			}
		}
	}

}
