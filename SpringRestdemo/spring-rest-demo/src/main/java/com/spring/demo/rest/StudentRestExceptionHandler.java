package com.spring.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// for Global Exception Handler
@ControllerAdvice
public class StudentRestExceptionHandler {
	
	//ExceptionHandler Int
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
		
		//StudentErrorResponse çÏê¨
		StudentErrorResponse err = new StudentErrorResponse();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	//add another exception handler StringURLóp
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception e){
		
		//StudentErrorResponse çÏê¨
		StudentErrorResponse err = new StudentErrorResponse();
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
				
				return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
}
