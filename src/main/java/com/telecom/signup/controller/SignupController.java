package com.telecom.signup.controller;

import org.springframework.web.bind.annotation.RestController;

import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.SignupApiData;
import com.telecom.signup.service.SignupService;

import java.nio.file.attribute.UserDefinedFileAttributeView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class SignupController {
	
	@Autowired
	public SignupService signupService;
	
	@PostMapping("auth-signup")
	public User signup(@RequestBody SignupApiData signupApiData) {
		
		User newEntry =	signupService.signup(signupApiData);
		
		return newEntry;
		
		
	}
	
	
	
	

}
