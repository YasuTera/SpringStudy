package com.spring.aopdemo.aspect;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
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
