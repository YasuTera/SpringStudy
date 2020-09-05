package com.demo.springdemo.mvc;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

		//check フォームチェック 空白除去
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			StringTrimmerEditor stringTrim = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrim);
		}
	
		@RequestMapping("/sForm")
		public String showForm(Model theModel) {
			theModel.addAttribute("customer", new Customer());
			
			return "customer-form";
		}
		
		//Validation
		@RequestMapping("/pForm")
		public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer,
			BindingResult theBindingResult) {
			
			System.out.println("Lastname: | "+ theCustomer.getLastName() +" |");
			
			System.out.println("Binding Result: "+ theBindingResult);
			System.out.println("\n\n\n\n");
			
			if(theBindingResult.hasErrors()) {
				return "customer-form";
			}else {
				return "customer-confirmation";
			}
		}

}
