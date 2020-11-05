package com.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	//c println��Spring ���O�̕����o�͂𓯂��n���ɂ���
	private static Logger mLog = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneService���擾
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		mLog.info("\n From Main: AroundDemoApp");
		mLog.info("getFortune�̎擾");
		
		//c �ďo
		//flag
		boolean tpW = true;
		String data = fServ.getFortune(tpW);
		
		mLog.info("\n�@My fortune is: " + data);
		
		mLog.info("�����I��");
		
		//close
		context.close();
	}

}
