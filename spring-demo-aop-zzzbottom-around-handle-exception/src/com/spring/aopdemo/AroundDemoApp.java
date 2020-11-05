package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		//spring config“Ç
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneServiceî•ñæ“¾
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n From Main: AroundDemoApp");
		System.out.println("getFortune‚Ìæ“¾");
		
		//c ŒÄo
		String data = fServ.getFortune();
		System.out.println("\n@My fortune is: " + data);
		
		System.out.println("ˆ—I—¹");
		
		//close
		context.close();
	}

}
