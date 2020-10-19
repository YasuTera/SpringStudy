package com.spring.hibernate.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.hibernate.webapp.entity.Customer;
import com.spring.hibernate.webapp.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//c 間にcustomer serviceを挟む
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get from customer service 間にCustomerService　インターフェースを挟む
		List<Customer> theCustomers = customerService.getCustomers();
		
		//Add to Model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showAddForm")
	public String showAddForm(Model theModel) {
		
		//c対応させる
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//DB処理
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showUpdForm")
	public String showFormUpd(@RequestParam("customerId") int theId, Model theModel) {
		
		//c 顧客情報をDBより取得
		Customer theCustomer = customerService.getCustomer(theId);
		
		//c 編集ページ遷移時フォームにデータが入った状態にする
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
}
