package com.spring.aopdemo;

public class Account {

	private String name;
	private String level;
	
	public Account() {
	}
	
	//constructor
	public Account(String name, String level) {
		this.name = name;
		this.level = level;
	}

	//getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	//toString
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}
	
}
