package com.example.spring_security_demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.spring_security_demo.Model.Student;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class StudentController {
	List<Student>student=new ArrayList<>(List.of(
			new Student(1,"Navin",34),
			new Student(2,"Kiran",89)
			
			));
	
	

	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest request){
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	
	
	
	@GetMapping("students")
	public List<Student>getStudents(){
		return student;
	}
	
}
