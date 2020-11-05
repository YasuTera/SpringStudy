package com.spring.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	//c printlnとSpring ログの文字出力を同じ系統にする
	private static Logger mLog = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		//spring config読込
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//TrafficFortuneService情報取得
		TrafficFortuneService fServ = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		mLog.info("\n From Main: AroundDemoApp");
		mLog.info("getFortuneの取得");
		
		//c 呼出
		String data = fServ.getFortune();
		mLog.info("\n　My fortune is: " + data);
		
		mLog.info("処理終了");
		
		//close
		context.close();
	}

}
