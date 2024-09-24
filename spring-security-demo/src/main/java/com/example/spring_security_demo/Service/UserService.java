package com.example.spring_security_demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.spring_security_demo.Model.User;
import com.example.spring_security_demo.doa.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
	

	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return repo.save(user);
	}
}
