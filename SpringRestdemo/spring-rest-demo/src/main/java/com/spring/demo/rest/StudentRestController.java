package com.spring.demo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> stdnt;
	
	//@PostConstruct 1度の読込処理のみとなる 
	@PostConstruct
	public void loadData() {
		
		stdnt = new ArrayList<>();
		
		stdnt.add(new Student("Beruf0", "Student0"));
		stdnt.add(new Student("Beruf1", "Student1"));
		stdnt.add(new Student("Beruf2", "Student2"));
		
		
	}
	
	//c　定義"/student"
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		return stdnt;
	}
	
	// "/student/{studentId}"用処理
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		//index作成 一つずつ取り出せるようになる
		
		//studentId error判断処理
		if((studentId >= stdnt.size()) || (studentId < 0)) {
			throw new StudentNotFoundException("Student id not found - "+ studentId);
		}
		
		return stdnt.get(studentId);
	}
	
}
