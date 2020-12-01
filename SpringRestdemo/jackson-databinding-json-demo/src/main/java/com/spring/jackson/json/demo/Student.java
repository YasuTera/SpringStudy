package com.spring.jackson.json.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//c getter/setterファイルに記述されていない 不明なJSONパラメータを無視する
@JsonIgnoreProperties(ignoreUnknown=true)
public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	//Address
	private Address address;
	
	//languages
	private String[] languages;
	
	//constructor
	public Student() {
		
	}
	
	//getter/setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	//Address
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//languages
	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	
	
	
}
