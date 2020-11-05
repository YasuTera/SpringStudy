package com.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	//c println��Spring ���O�̕����o�͂𓯂��n���ɂ���
	private static Logger mLog = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneService���擾
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		mLog.info("\n From Main: AroundDemoApp");
		mLog.info("getFortune�̎擾");
		
		//c �ďo
		String data = fServ.getFortune();
		mLog.info("\n�@My fortune is: " + data);
		
		mLog.info("�����I��");
		
		//close
		context.close();
	}

}
