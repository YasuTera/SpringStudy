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

	// CustomerService�N���X�ϐ���`
	@Autowired
	private CustomerService cs;
	
	//c //c �ڋq�ꗗ�փ��_�C���N�g�\��
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the service
		List<Customer> lisCs = cs.getCustomers();
				
		//c ���C������
		theModel.addAttribute("customers", lisCs);
		
		return "list-customers";
	}
	
	//c �ڋq���쐬�ǉ��t�H�[��
	@GetMapping("/showAddForm")
	public String showFormForAdd(Model theModel) {

		Customer newCs = new Customer();
		
		//c ���C������
		theModel.addAttribute("customer", newCs);
		
		return "customer-form";
	}
	
	//DB�ۑ�
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer saveCs) {
		
		//c ���C������
		cs.saveCustomer(saveCs);	
		
		//c �ڋq�ꗗ�փ��_�C���N�g
		return "redirect:/customer/list";
	}
	
	//c �ڋq���X�V����
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
	
	//c �ڋq���폜����
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int deleteCs) {
		
		// delete the customer
		cs.deleteCustomer(deleteCs);
		
		//c �ڋq�ꗗ�փ��_�C���N�g
		return "redirect:/customer/list";
	}
}










