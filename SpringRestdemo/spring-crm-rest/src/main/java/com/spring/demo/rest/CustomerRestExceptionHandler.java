package com.spring.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//Exception CustomerNotFoundException (CustomerIDÇÃó·äOèàóù)
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException e){
		
		//CustomerErrorResponse
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),
																e.getMessage(),
																System.currentTimeMillis());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	//c ëºÇ∑Ç◊ÇƒÇÃó·äO catch All
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception e){
		
		//400 error
		CustomerErrorResponse err = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),
																e.getMessage(),
																System.currentTimeMillis());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
