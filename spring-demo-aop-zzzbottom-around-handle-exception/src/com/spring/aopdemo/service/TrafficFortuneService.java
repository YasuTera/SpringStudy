package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try{
			
			//c 実行時間検証
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return "今朝は酷い渋滞でした"	;	
	}

	public String getFortune(boolean tpW) {
		
		if(tpW) {
			throw new RuntimeException("事故のため高速道路を閉鎖しています。");
		}
		
		return getFortune();
	}
}
