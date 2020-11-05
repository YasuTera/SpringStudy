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
	
	//c �w�胁�\�b�h�O�ɌĂяo�� combineNoGetterSetter()���\�b�h���s�O�Ɏ��s
	@Before("com.spring.aopdemo.aspect.combineAopExpressions.combineNoGetterSetter()") 
	public void beforeAddAccount(JoinPoint jp) {
		
		System.out.println("=====>>> From beforeAddAccount");
		
		//c ���\�b�h�̊m�F
		MethodSignature ms = (MethodSignature) jp.getSignature();
		System.out.println("Method: " + ms);
		
		//c ���\�b�h�����̊m�F
		//c
		Object[] oList = jp.getArgs();
		
		//loop
		for(Object tmp : oList) {
			System.out.println(tmp);
			
			//check
			if(tmp instanceof Account) {
				
				Account ac = (Account) tmp;
				System.out.println("�A�J�E���g��: " + ac.getName());
				System.out.println("���x��: " + ac.getLevel());
			}
		}
	}

}
