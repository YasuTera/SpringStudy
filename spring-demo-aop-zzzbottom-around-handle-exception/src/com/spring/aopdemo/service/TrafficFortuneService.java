package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try{
			
			//c ���s���Ԍ���
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return "�����͍����a�؂ł���"	;	
	}

	public String getFortune(boolean tpW) {
		
		if(tpW) {
			throw new RuntimeException("���̂̂��ߍ������H������Ă��܂��B");
		}
		
		return getFortune();
	}
}
