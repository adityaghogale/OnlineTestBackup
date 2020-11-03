package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.UserRepository;


/**
 * 
 * @author Aditya Ghogale
 *
 */
public class TestDataProvierService {

	//reference of repository
	@Autowired
	private UserRepository repository;
	
	//email validation regular expression
	private String emailRegex="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
	//login method
	public User userLogin(String username,String password) {
		return repository.findByUserName(username);
	}
	
	//register method
	public User userRegister(User user) {
		User tmpUser;
		if(repository.findByUserName(user.getUserName())!=null) throw new UserNotFoundException("This UserName is already taken");
		if("".equals(user.getUserName()) || "".equals(user.getPassword()))throw new UserNotFoundException("User details cannot be empty");
		if(!(user.getEmail().matches(emailRegex)))throw new UserNotFoundException("User email must be in proper format");
		user.setTestId(0);
		tmpUser= repository.save(user);
		return tmpUser;
	}
}
