package com.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		
		try{
			
			//c ÀsŠÔŒŸØ
			TimeUnit.SECONDS.sleep(5);
		}
		catch(InterruptedException e) {
			
			e.printStackTrace();
		}
		
		return "¡’©‚Í“‚¢a‘Ø‚Å‚µ‚½"	;	
	}

	public String getFortune(boolean tpW) {
		
		if(tpW) {
			throw new RuntimeException("–ŒÌ‚Ì‚½‚ß‚‘¬“¹˜H‚ğ•Â½‚µ‚Ä‚¢‚Ü‚·B");
		}
		
		return getFortune();
	}
}
