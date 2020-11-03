package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class UserLoginController {

	//Instance of proxy
	@Autowired
	private LoginServiceProxy proxy;
	
	//object of logger
	private static final Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	//login ur mapping in service layer
	@GetMapping(path = "/login/{userName}/{password}")
	public User findByuserName(@PathVariable String userName,@PathVariable String password){
		User tmpUser = proxy.findByuserName(userName,password);
		if(tmpUser.getUserName()==null) throw new UserNotFoundException("Invalid username or password");
		//save info in logger file
		logger.info(""+tmpUser.getUserName()+" logged in");
		return tmpUser;
	}
	
}
