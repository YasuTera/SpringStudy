package com.spring.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class combineAopExpressions {
	
	//c �w�胁�\�b�h�O�ɌĂяo��
	//c .. �͂��ׂĂ̈����i���l����{)�ɑΉ����郏�C���h�J�[�h
	@Pointcut("execution(* com.spring.aopdemo.dao.*.*(..))") //c * ���C���h�J�[�h�w��ŗl�X�ȃA�N�Z�X�C���q, ���\�b�h/�N���X��,�@�߂�l, �����Ȃǂ��w��ł���(�A�N�Z�X�C���q�͏ȗ���)
	public void kamash() {}		
		
	//getter/setter�p@Pointcut
	@Pointcut("execution(* com.spring.aopdemo.dao.*.get*(..))")
	public void getter() {}
		
	@Pointcut("execution(* com.spring.aopdemo.dao.*.set*(..))")
	public void setter() {}
		
	//getter/setter @Pointcut����
	@Pointcut("kamash() && !(getter() || setter())")
	public void combineNoGetterSetter() {}

}
