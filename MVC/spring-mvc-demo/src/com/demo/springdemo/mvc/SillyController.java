package com.demo.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SillyController {
	
	//process
	@RequestMapping("/sForm")
	public String displayForm() {
		return "silly";
	}

}
