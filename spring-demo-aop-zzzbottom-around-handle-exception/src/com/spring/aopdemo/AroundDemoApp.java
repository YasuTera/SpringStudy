package com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		//spring config読込
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneService情報取得
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\n From Main: AroundDemoApp");
		System.out.println("getFortuneの取得");
		
		//c 呼出
		String data = fServ.getFortune();
		System.out.println("\n　My fortune is: " + data);
		
		System.out.println("処理終了");
		
		//close
		context.close();
	}

}
