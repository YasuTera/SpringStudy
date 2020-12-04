package com.spring.demo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring.demo.model.Customer;

@Service
public class CustomerServiceRestClientImpl implements CustomerService {

	private RestTemplate restTmp;

	private String serverUrl; //${crm.rest.url}�i�[�p�@localhost URL
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CustomerServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String localUrl) {
		restTmp = theRestTemplate;
		serverUrl = localUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + serverUrl);
	}
	
	@Override
	public List<Customer> getCustomers() {
		
		//log
		logger.info("in getCustomers(): Calling REST API " + serverUrl);

		// REST�Ăяo���ϐ���`�@RESTtemplate
		ResponseEntity<List<Customer>> responseEntity = restTmp.exchange(serverUrl, 
																		HttpMethod.GET, 
																		null, 
																		new ParameterizedTypeReference<List<Customer>>() {});

		// c �ڋq�ꗗ�擾
		List<Customer> cstm = responseEntity.getBody();

		logger.info("in getCustomers(): customers" + cstm);
		
		return cstm;
	}

	@Override
	public Customer getCustomer(int cId) {

		//log
		logger.info("in getCustomer(): Calling REST API " + serverUrl);

		// RESTtemplate���g���ČĂяo��
		Customer csOb = 
				restTmp.getForObject(serverUrl + "/" + cId, 
										  Customer.class);

		logger.info("in saveCustomer(): theCustomer=" + csOb);
		
		return csOb;
	}

	@Override
	public void saveCustomer(Customer saveCs) {
		
		//log
		logger.info("in saveCustomer(): Calling REST API " + serverUrl);
		
		int employeeId = saveCs.getId();

		// RESTtemplate���g���ČĂяo��
		if (employeeId == 0) {
			//c �ڋq�ǉ�����
			restTmp.postForEntity(serverUrl, saveCs, String.class);			
		
		} else {
			//c �ڋq���X�V����
			restTmp.put(serverUrl, saveCs);
		}

		//log
		logger.info("in saveCustomer(): success");	
	}

	@Override
	public void deleteCustomer(int deleteCs) {
		
		//log
		logger.info("in deleteCustomer(): Calling REST API " + serverUrl);

		// RESTtemplate���g���ČĂяo��
		restTmp.delete(serverUrl + "/" + deleteCs);
		
		//log
		logger.info("in deleteCustomer(): deleted customer theId=" + deleteCs);
	}

}
