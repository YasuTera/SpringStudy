package com.spring.demo.rest;

public class StudentNotFoundException extends RuntimeException{

	//generate constuctor from superclass
	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentNotFoundException(String message) {
		super(message);
		
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		
	}
	
}
