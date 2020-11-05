package com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSomething() {
		
		System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP METHOD");
		
		return true;
	}
	
	public void goToSleep() {
		
		System.out.println(getClass() + ": Going to sleep for a while...");
	}
}
