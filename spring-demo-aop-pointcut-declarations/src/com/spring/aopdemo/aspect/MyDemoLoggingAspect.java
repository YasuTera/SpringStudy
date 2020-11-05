package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//c �w�胁�\�b�h�O�ɌĂяo��
	//c .. �͂��ׂĂ̈����i���l����{)�ɑΉ����郏�C���h�J�[�h
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ���C���h�J�[�h�w��ŗl�X�ȃA�N�Z�X�C���q, ���\�b�h/�N���X��,�@�߂�l, �����Ȃǂ��w��ł���(�A�N�Z�X�C���q�͏ȗ���)
	private void kamash() {}
	
	//c �w�胁�\�b�h�O�ɌĂяo�� kamashi���\�b�h���s�O�Ɏ��s
	@Before("kamash()") 
	public void beforeAddAccount() {
		
		System.out.println("=====>>> From beforeAddAccount");
	}
	
	//c ���@Before��Ɍďo
	@Before("kamash()")
	public void performApiAnalytics() {
		
		System.out.println("=====>>> From performApiAnalytics()");
	}

}
