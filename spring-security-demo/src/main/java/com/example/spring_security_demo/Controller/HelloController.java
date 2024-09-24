package com.example.spring_security_demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("hello")
	public String greet(HttpServletRequest request) {
		return "Hello World" + request.getSession().getId();
	}
	
	@GetMapping("about")
	public String about() {
		return "Running" ;
	}
}
