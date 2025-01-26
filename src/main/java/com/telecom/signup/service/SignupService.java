package com.telecom.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.SignupApiData;
import com.telecom.signup.repository.UserRepository;

@Service
public class SignupService {
	
	@Autowired
	public UserRepository userRepository;
	
	
	public User signup(SignupApiData signupApiData) {
		
		
		User user = new User();
		
		user.setEmail(signupApiData.getEmail());
		user.setName(signupApiData.getName());
		user.setPassword(signupApiData.getPassword());
		
		User newUser = userRepository.save(user);
		
		
		
		
		return newUser;
		
		
	}
	
	
	

}
