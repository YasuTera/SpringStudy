package com.demo.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService") //多数のクラスで同じインターフェースを継承実装の場合　個別に指定ができる
	private FortuneService fs;
	
	//default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: This string is from default constructor");
	}
	
	/*
	//setter
	@Autowired
	public void changedSetter(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: This string is from changedSetter method");
		fs = theFortuneService;
	}
	
	
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fs = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		
		return "Practice your backhand volley!";
	}

	@Override
	public String getDailyFortune() {
		return fs.getFortune();
	}

}
