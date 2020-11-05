package com.spring.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	//c printlnとSpring ログの文字出力を同じ系統にする
	private Logger mLog = Logger.getLogger(getClass().getName());
	
	//@Around section
	@Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{
		
		//c 対象としているメソッド表示
		String mth = pjp.getSignature().toShortString();
		mLog.info("\n=====>>> From @Around method: " + mth);	
		
		//start timestamp
		long begin = System.currentTimeMillis();
		
		//set result
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			
			//c 例外log
			mLog.warning(e.getMessage());
			
			//c 例外結果を投げる(Mainクラス・メソッド側で処理される)
			throw e;
		}
		
		//end timestamp
		long end = System.currentTimeMillis();
		
		//c 実行時間の表示
		long duration = end - begin;
		mLog.info("\n=====>>>Duration: " + duration/1000.0 + " seconds");
		
		//c 結果返却
		return result;
	}
	
	//@After(finally) section //Spring 5.2.7より @Afterが@AfterThrowingの後に実行される仕様になった
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		
	//c どのメソッドを指定しているかの確認
	String mth = jp.getSignature().toShortString();
	mLog.info("\n=====>>> From @After(finally) method: " + mth);	
	}
	
	//@AfterThrowing section
	@AfterThrowing(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
		
		//c どのメソッドを指定しているかの確認
		String mth = jp.getSignature().toShortString();
		mLog.info("\n=====>>> From @AfterThrowing method: " + mth);
				
		//c 結果表示
		mLog.info("\n=====>>> result: " + exc);
	}
	
	//@AfterReturning section
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAdvice(JoinPoint jp, List<Account> res) {
		
		//c どのメソッドを指定しているかの確認
		String mth = jp.getSignature().toShortString();
		mLog.info("\n=====>>> From @AfterReturning method: " + mth);
		
		//c 結果表示
		mLog.info("\n=====>>> result: " + res);
		
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
		
		mLog.info("=====>>> From beforeAddAccount");
		
		//c メソッドの確認
		MethodSignature ms = (MethodSignature) jp.getSignature();
		mLog.info("Method: " + ms);
		
		//c メソッド引数の確認
		//c
		Object[] oList = jp.getArgs();
		
		//loop
		for(Object tmp : oList) {
			mLog.info(tmp.toString());
			
			//check
			if(tmp instanceof Account) {
				
				Account ac = (Account) tmp;
				mLog.info("アカウント名: " + ac.getName());
				mLog.info("レベル: " + ac.getLevel());
			}
		}
	}

}
