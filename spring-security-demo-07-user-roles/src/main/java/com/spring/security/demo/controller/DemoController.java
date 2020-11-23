package com.spring.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	//landing page
	@GetMapping("/")
	public String showLanding() {
		return "landing";
	}
	
	//root page
	@GetMapping("/employees")
	public String showHome() {
		return "home";
	}
}
