package com.demo.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@RequestMapping("/sForm")
	public String showForm(Model model) {
		
		//create student object
		Student student = new Student();
		
		//add student object to the model
		model.addAttribute("student", student);
		
		return "student-form";
	}
	
	@RequestMapping("/pForm")
	public String processForm(@ModelAttribute("student") Student theStudent) {
		
		//log input data
		System.out.println("theStudent" + theStudent.getFirstName() + " " + theStudent.getLastName());
		
		return "student-confirmation";
	}
}
