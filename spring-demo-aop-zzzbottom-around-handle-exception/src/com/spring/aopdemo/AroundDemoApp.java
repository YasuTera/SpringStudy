package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		//spring config�Ǎ�
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneService���擾
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n From Main: AroundDemoApp");
		System.out.println("getFortune�̎擾");
		
		//c �ďo
		String data = fServ.getFortune();
		System.out.println("\n�@My fortune is: " + data);
		
		System.out.println("�����I��");
		
		//close
		context.close();
	}

}
