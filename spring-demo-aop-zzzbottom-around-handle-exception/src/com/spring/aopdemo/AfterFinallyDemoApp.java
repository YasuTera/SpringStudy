package com.spring.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//Account bean���擾
		AccountDAO aDao = context.getBean("accountDAO", AccountDAO.class);
		
		//c ��O����
		List<Account> listAcc = null;
		try {
			// flag ���ؗp
			boolean trW = false;
			
			listAcc = aDao.findAccounts(trW);
		}
		catch(Exception e) {
			//c �ŏ���MyDemoLoggingAspect.afterThrowingFindAccountsAdvice(Joinpoint,Exception)�����ŃG���[���o�͌�AJava�{�̂��瓯�G���[�o��
			System.out.println("\n\n �G���[�ł�: " + e);
		}
		
		//c �p���啶���̃A�J�E���g���擾
		System.out.println("\n\nMain���\�b�h : AfterThrowingDemoApp�N���X���\n----");
		System.out.println(listAcc + "\n");
		
		//close
		context.close();
	}

}
