package com.demo.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.demo.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0, message="0より大きな値を入力してください")
	@Max(value=10, message="10より小さな値を入力してください")
	private Integer freePss;
	
	//a　正規表現
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="5文字以内で入力してください")
	private String postalCode;
	
	//custom validation
	@CourseCode(value="Beruf", message="Berufで始まるコードを入力してください")
	private String courseCode;
	
	
	//getters and setters
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
	
	
	public Integer getFreePss() {
		return freePss;
	}
	public void setFreePss(Integer freePss) {
		this.freePss = freePss;
	}
	
	

}
