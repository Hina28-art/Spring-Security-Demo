package com.example.spring_security_demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_security_demo.Model.User;
import com.example.spring_security_demo.Service.JwtService;
import com.example.spring_security_demo.Service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtService jwtService;
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}
	
	@PostMapping("login")
	public String login(@RequestBody User user) {
		Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()) );
	
		if(authentication.isAuthenticated()) {
			return jwtService.generateToken(user.getUsername());
		}
		else {
			return "Login Failed";
		}
	
	
	}
}
