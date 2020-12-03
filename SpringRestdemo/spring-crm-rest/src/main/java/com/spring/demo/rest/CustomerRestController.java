package com.spring.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Customer;
import com.spring.demo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//CustomerService�R�Â�
	@Autowired
	private CustomerService cs;
	
	// mapping GET /customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return cs.getCustomers();
	}
	
	//mapping GET /customers/{customerId}
	@GetMapping("/customers/{cId}")
	public Customer getCustomer(@PathVariable int cId) {
		
		Customer theCustomer = cs.getCustomer(cId);
		
		//c �G���[�y�[�W�J�ڏ����@���݂��Ȃ�ID URL��String URL
		if(theCustomer == null) {
			throw new CustomerNotFoundException("�ڋqID��������܂��� - " + cId);
		}
		
		return theCustomer;
	}
	
	
	//mapping POST /customers
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer addCs) {
		
		//0/null�@Insert�����ɂȂ�@Hibernate�̎d�l�@
		addCs.setId(0);
		
		cs.saveCustomer(addCs);
		
		return addCs;
	}
	
}
