package com.spring.hibernate.webapp.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger mLog = Logger.getLogger(getClass().getName());
	
	//setup controller pointcut
	@Pointcut("execution(* com.spring.hibernate.webapp.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//setup service pointcut
	@Pointcut("execution(* com.spring.hibernate.webapp.service.*.*(..))")
	private void forServicePackage() {}
	
	//setup dao pointcut
	@Pointcut("execution(* com.spring.hibernate.webapp.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void appFlow() {}
	
	//@Before section
	@Before("appFlow()")
	public void before(JoinPoint jp) {
		
		//c �w�肳��Ă��郁�\�b�h�̊m�F�@�\��
		String mth = jp.getSignature().toShortString();
		mLog.info("=====>>> @Before �w��̃��\�b�h���ďo �Ăяo���ꂽ���\�b�h: " + mth);
		
		//c �w�胁�\�b�h�̈����\��
		Object[] args = jp.getArgs();
		
		//loop
		for(Object tmp : args) {
			
			mLog.info("=====>>args �����Ŏ󂯓n���ꂽ�f�[�^: " + tmp);
		}
	}
	
	//@AfterReturning section
	@AfterReturning(pointcut="appFlow()", returning="res")
	public void afterReturning(JoinPoint jp, Object res) {
		
		//c �w�肳��Ă��郁�\�b�h�̊m�F�@�\��
		String mth = jp.getSignature().toShortString();
		mLog.info("=====>>> @AfterReturning �w��̃��\�b�h���ďo �Ăяo���ꂽ���\�b�h: " + mth);
		
		//c �߂�l�\��
		mLog.info("=====>>> result: " + res);
	}
}
