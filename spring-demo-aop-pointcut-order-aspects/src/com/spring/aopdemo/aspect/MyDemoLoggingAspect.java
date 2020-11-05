package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	//c �w�胁�\�b�h�O�ɌĂяo�� combineNoGetterSetter()���\�b�h���s�O�Ɏ��s
	@Before("com.spring.aopdemo.aspect.combineAopExpressions.combineNoGetterSetter()") 
	public void beforeAddAccount() {
		
		System.out.println("=====>>> From beforeAddAccount");
	}

}
