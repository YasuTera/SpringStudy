package com.spring.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	//
	public List<Account> findAccounts(){
		List<Account> lAcc = new ArrayList<>();
		
		//testAccount
		Account tmp1 = new Account("BerufOne", "Silver");
		Account tmp2 = new Account("BerufTwo", "Platinum");
		Account tmp3 = new Account("BerufThree", "Gold");
		
		//list‚ÉŽó‚¯“n‚µ
		lAcc.add(tmp1);
		lAcc.add(tmp2);
		lAcc.add(tmp3);
		
		return lAcc;
	}
	
	public void addAccount(Account acc, boolean flag) {
		
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public boolean doWork() {
		return false;
	}

	
	//getter/setter
	public String getName() {
		System.out.println(getClass() + ": in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + ": in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode()");
		this.serviceCode = serviceCode;
	}

}
