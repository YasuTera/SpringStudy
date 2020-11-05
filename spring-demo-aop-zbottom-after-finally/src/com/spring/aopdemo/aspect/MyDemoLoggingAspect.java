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
	
	//@After(finally) section //Spring 5.2.7��� @After��@AfterThrowing�̌�Ɏ��s�����d�l�ɂȂ���
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		
	//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
	String mth = jp.getSignature().toShortString();
	System.out.println("\n=====>>> From @After(finally) method: " + mth);	
	}
	
	//@AfterThrowing section
	@AfterThrowing(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
		
		//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
		String mth = jp.getSignature().toShortString();
		System.out.println("\n=====>>> From @AfterThrowing method: " + mth);
				
		//c ���ʕ\��
		System.out.println("\n=====>>> result: " + exc);
	}
	
	//@AfterReturning section
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAdvice(JoinPoint jp, List<Account> res) {
		
		//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
		String mth = jp.getSignature().toShortString();
		System.out.println("\n=====>>> From @AfterReturning method: " + mth);
		
		//c ���ʕ\��
		System.out.println("\n=====>>> result: " + res);
		
		//c
		
		//c �A�J�E���g�����p���啶���ɕϊ�
		convertAccountNamesToUpperCase(res);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> res) {
		//loop �����擾����
		for(Account tmpAcc : res) {
			
			//c �A�J�E���g����啶���ɕϊ����Ď擾
			String uppName = tmpAcc.getName().toUpperCase();
			
			//c �擾�������̂�set
			tmpAcc.setName(uppName);
		}
	}

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
