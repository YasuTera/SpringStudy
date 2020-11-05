package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//c �w�胁�\�b�h�O�ɌĂяo��
	//c .. �͂��ׂĂ̈����i���l����{)�ɑΉ����郏�C���h�J�[�h
	@Before("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ���C���h�J�[�h�w��ŗl�X�ȃA�N�Z�X�C���q, ���\�b�h/�N���X��,�@�߂�l, �����Ȃǂ��w��ł���(�A�N�Z�X�C���q�͏ȗ���)
	public void beforeAddAccount() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
	}

}
