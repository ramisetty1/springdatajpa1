package com.telecom.signup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.ProfileUpdateApidata;
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
	
	
	public boolean profileUpdateService(ProfileUpdateApidata profileUpdateApidata) {
		
		Optional<User> dbresponseUser = userRepository.findById(profileUpdateApidata.getId());
		
		if (dbresponseUser.isPresent()== true) {
			
			User dbUser =	dbresponseUser.get();
			
			dbUser.setPassword(profileUpdateApidata.getPassword());
			userRepository.save(dbUser);
			return true;
			
		}else {
			return false;
			
		}
		
	}
	
	
	

}
