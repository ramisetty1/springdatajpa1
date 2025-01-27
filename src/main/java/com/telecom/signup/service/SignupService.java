package com.telecom.signup.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.EmailApidata;
import com.telecom.signup.pojo.LoginApidata;
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
	
	
	
	public Optional<User> getUserData(int id) {
		
		Optional<User> dbResponse =	userRepository.findById(id);
		return dbResponse;
		
	}
	
	
	
	
	public Object databyemail(EmailApidata emailApidata) {
		
		Optional<User> dbDataOptional =	userRepository.findByEmail(emailApidata.getEmail());
		if (dbDataOptional.isPresent() == true) {
			return dbDataOptional.get();
		}
		else {
			return "user not found";
		}
	}
	
	
	public Object loginService(LoginApidata loginApidata) {
		
		Optional<User> dbdataOptional =	userRepository.dbLoginWithQuery(loginApidata.getEmail(), loginApidata.getPassword());
		if (dbdataOptional.isPresent() == true) {
			
			return dbdataOptional.get();
			
		}
		else {
			return "user not found";
		}
		
	}
	
	
	
	
	
	
	
	

}
