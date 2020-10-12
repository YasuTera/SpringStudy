package com.spring.hibernate.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.hibernate.webapp.dao.customerDAO;
import com.spring.hibernate.webapp.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//DAO
	@Autowired
	private customerDAO customerDao;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get from DAO
		List<Customer> theCustomers = customerDao.getCustomers();
		
		//Add to Model
		theModel.addAttribute("customers", theCustomers);
		
		
		
		return "list-customers";
	}
}
