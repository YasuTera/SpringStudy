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
	
	//leader page
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	// systems page
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
}
