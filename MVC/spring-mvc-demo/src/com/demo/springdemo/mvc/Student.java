package com.demo.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	private String country;
	
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLang;
	
	private String[] operatingSys;
	
	public Student() {
		//countrycode
		countryOptions = new LinkedHashMap<>();
		
		//key, value
		countryOptions.put("BR", "ブラジル");
		countryOptions.put("FR", "フランス");
		countryOptions.put("DE", "ドイツ");
		countryOptions.put("IN", "インド");
		countryOptions.put("US", "アメリカ");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	//List
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	//Radio button
	public String getFavoriteLang() {
		return favoriteLang;
	}

	public void setFavoriteLang(String favoriteLang) {
		this.favoriteLang = favoriteLang;
	}

	//OS
	public String[] getOperatingSys() {
		return operatingSys;
	}

	public void setOperatingSys(String[] operatingSys) {
		this.operatingSys = operatingSys;
	}
	
	
	
	
	
	
	
	
	
	

}
