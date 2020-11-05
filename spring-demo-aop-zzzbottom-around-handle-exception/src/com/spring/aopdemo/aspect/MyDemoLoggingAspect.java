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
	
	//c println��Spring ���O�̕����o�͂𓯂��n���ɂ���
	private Logger mLog = Logger.getLogger(getClass().getName());
	
	//@Around section
	@Around("execution(* com.spring.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint pjp) throws Throwable{
		
		//c �ΏۂƂ��Ă��郁�\�b�h�\��
		String mth = pjp.getSignature().toShortString();
		mLog.info("\n=====>>> From @Around method: " + mth);	
		
		//start timestamp
		long begin = System.currentTimeMillis();
		
		//set result
		Object result = null;
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			
			//c ��Olog
			mLog.warning(e.getMessage());
			
			//c ��O���ʂ𓊂���(Main�N���X�E���\�b�h���ŏ��������)
			throw e;
		}
		
		//end timestamp
		long end = System.currentTimeMillis();
		
		//c ���s���Ԃ̕\��
		long duration = end - begin;
		mLog.info("\n=====>>>Duration: " + duration/1000.0 + " seconds");
		
		//c ���ʕԋp
		return result;
	}
	
	//@After(finally) section //Spring 5.2.7��� @After��@AfterThrowing�̌�Ɏ��s�����d�l�ɂȂ���
	@After("execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint jp) {
		
	//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
	String mth = jp.getSignature().toShortString();
	mLog.info("\n=====>>> From @After(finally) method: " + mth);	
	}
	
	//@AfterThrowing section
	@AfterThrowing(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", throwing="exc")
	public void afterThrowingFindAccountsAdvice(JoinPoint jp, Throwable exc) {
		
		//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
		String mth = jp.getSignature().toShortString();
		mLog.info("\n=====>>> From @AfterThrowing method: " + mth);
				
		//c ���ʕ\��
		mLog.info("\n=====>>> result: " + exc);
	}
	
	//@AfterReturning section
	@AfterReturning(pointcut="execution(* com.spring.aopdemo.dao.AccountDAO.findAccounts(..))", returning="res")
	public void afterReturningFindAdvice(JoinPoint jp, List<Account> res) {
		
		//c �ǂ̃��\�b�h���w�肵�Ă��邩�̊m�F
		String mth = jp.getSignature().toShortString();
		mLog.info("\n=====>>> From @AfterReturning method: " + mth);
		
		//c ���ʕ\��
		mLog.info("\n=====>>> result: " + res);
		
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
		
		mLog.info("=====>>> From beforeAddAccount");
		
		//c ���\�b�h�̊m�F
		MethodSignature ms = (MethodSignature) jp.getSignature();
		mLog.info("Method: " + ms);
		
		//c ���\�b�h�����̊m�F
		//c
		Object[] oList = jp.getArgs();
		
		//loop
		for(Object tmp : oList) {
			mLog.info(tmp.toString());
			
			//check
			if(tmp instanceof Account) {
				
				Account ac = (Account) tmp;
				mLog.info("�A�J�E���g��: " + ac.getName());
				mLog.info("���x��: " + ac.getLevel());
			}
		}
	}

}
