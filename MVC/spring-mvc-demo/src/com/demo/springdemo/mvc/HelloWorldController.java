package com.demo.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //parent Mapping
public class HelloWorldController {

	//show init HTML Form
	@RequestMapping("/sForm") //sub Mapping
	public String showForm() {
		return "helloworld-form";
	}
	
	//process
	@RequestMapping("/pForm")
	public String processForm() {
		return "helloworld";
	}
	
	//read, add data
	@RequestMapping("/pFormV2")
	public String shout(HttpServletRequest request, Model model) {
		
		//　Form受け取り
		String name = request.getParameter("guest");
		
		//UPPERCASE
		name = name.toUpperCase();
		
		//　メッセージ作成　追加
		String result = "Hey! " + name;
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/pFormV3")
	public String pFormThree(
			@RequestParam("guest") String st, 
			Model model) {
		
		//UPPERCASE
		st = st.toUpperCase();
		
		//　メッセージ作成　追加
		String result = "Good to see you " + st;
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
