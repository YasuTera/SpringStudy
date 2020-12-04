package com.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.demo.model.Customer;
import com.spring.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// CustomerServiceクラス変数定義
	@Autowired
	private CustomerService cs;
	
	//c //c 顧客一覧へリダイレクト表示
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> lisCs = cs.getCustomers();
				
		//c メイン処理
		theModel.addAttribute("customers", lisCs);
		
		return "list-customers";
	}
	
	//c 顧客情報作成追加フォーム
	@GetMapping("/showAddForm")
	public String showFormForAdd(Model theModel) {

		Customer newCs = new Customer();
		
		//c メイン処理
		theModel.addAttribute("customer", newCs);
		
		return "customer-form";
	}
	
	//DB保存
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer saveCs) {
		
		//c メイン処理
		cs.saveCustomer(saveCs);	
		
		//c 顧客一覧へリダイレクト
		return "redirect:/customer/list";
	}
	
	//c 顧客情報更新処理
	@GetMapping("/showUpdateForm")
	public String showFormForUpdate(@RequestParam("customerId") int cId,
									Model theModel) {
		
		// get the customer from our service
		Customer cstm = cs.getCustomer(cId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", cstm);
		
		// send over to our form		
		return "customer-form";
	}
	
	//c 顧客情報削除処理
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int deleteCs) {
		
		// delete the customer
		cs.deleteCustomer(deleteCs);
		
		//c 顧客一覧へリダイレクト
		return "redirect:/customer/list";
	}
}










