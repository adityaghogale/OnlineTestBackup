package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.proxy.LoginServiceProxy;

/**
 * 
 * @author Aditya Ghogale
 *
 */

@RestController
public class RegistrationController {

	//Instance of proxy service
	@Autowired
	private LoginServiceProxy proxy;
	
	//regular expression to check credentials
	
	private String emailRegex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
	
	//method call for registration
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		User tmpUser;
		if("".equals(user.getUserName()) || "".equals(user.getUserPassword()))throw new UserNotFoundException("User details cannot be empty");
		if(!(user.getEmail().matches(emailRegex)))throw new UserNotFoundException("User email must be in proper format");
		tmpUser= proxy.registerUser(user);
		
		if(tmpUser.getUserId()==0)
			throw new UserNotFoundException("User With username "+user.getUserName()+" already exist");
		else 
			return tmpUser;
		
	}
}
