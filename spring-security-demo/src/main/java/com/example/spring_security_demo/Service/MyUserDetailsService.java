package com.example.spring_security_demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.spring_security_demo.Model.User;
import com.example.spring_security_demo.Model.UserPrincipal;
import com.example.spring_security_demo.doa.UserRepo;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=repo.findByUsername(username);
		
		if(user==null) {
			System.out.println("User 404");
			throw new UsernameNotFoundException("User 404");
			
		}
	
		return new UserPrincipal(user);
	}
}
