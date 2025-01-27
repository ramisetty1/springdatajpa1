package com.telecom.signup.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.telecom.signup.entity.User;
import com.telecom.signup.pojo.EmailApidata;
import com.telecom.signup.service.SignupService;

@RestController
public class GetDetailscontroller {
	
	@Autowired
	public SignupService signupService;
	
	@GetMapping("user/{id}")
	public HashMap<Object, Object> getUserdetails(@PathVariable int id) {
		Optional<User> user = signupService.getUserData(id);
		
		HashMap<Object, Object> resMap = new HashMap<Object, Object>();
		
		if (user.isPresent()== true) {
			resMap.put("result", "success");
			resMap.put("data", user.get());
			
		}else {
			resMap.put("result", "failed");
			resMap.put("data", "user not found");
			
		}
		
		
		
		return resMap;
		
	}
	
	
	@PostMapping("useremail")
	public Object getDetailsbyUseremail(@RequestBody EmailApidata emailApidata) {
		return signupService.databyemail(emailApidata);
	
		
		
	}
	
	
	
	
	
}
