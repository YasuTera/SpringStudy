package com.spring.springboot.demo.bootdemoapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	//c サーバ接続時に表示するページと関連付け
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World. " + LocalDateTime.now();
	}
	
	//for workout
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "getDailyWorkout() ran";
		
	}
	
	//for fortune
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "getDailyFortune() ran";
		
	}
}
