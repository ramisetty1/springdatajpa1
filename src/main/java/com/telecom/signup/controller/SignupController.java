package com.telecom.signup.controller;

import org.springframework.web.bind.annotation.RestController;

import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.ProfileUpdateApidata;
import com.telecom.signup.pojo.SignupApiData;
import com.telecom.signup.service.SignupService;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.STRING;

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
	@PostMapping("updatePrpfile")
	public Map<String, String> updateProfile(@RequestBody ProfileUpdateApidata profileUpdateApidata) {
		boolean isUpdate =	signupService.profileUpdateService(profileUpdateApidata);
		
		HashMap<String, String> responseHashMap = new HashMap<String, String>();
		if (isUpdate == true) {
			
			
			responseHashMap.put("result", "success");
			responseHashMap.put("message", "successfully updated");
			
		}else {
			responseHashMap.put("result", "failed");
			responseHashMap.put("message", "user not found");
			
		}
		return responseHashMap;
		
		
		
		
	}
	
	
	
	

}
