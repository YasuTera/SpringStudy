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
	@Min(value=0, message="0���傫�Ȓl����͂��Ă�������")
	@Max(value=10, message="10��菬���Ȓl����͂��Ă�������")
	private Integer freePss;
	
	//a�@���K�\��
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="5�����ȓ��œ��͂��Ă�������")
	private String postalCode;
	
	//custom validation
	@CourseCode(value="Beruf", message="Beruf�Ŏn�܂�R�[�h����͂��Ă�������")
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
