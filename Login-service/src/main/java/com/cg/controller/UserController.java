package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.UserRepository;
import com.cg.security.CustomEncryptorDecryptor;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Aditya Ghogale
 *
 */

@Api(value = "Login swagger")
@RestController
public class UserController {

	// Instance of repository to perform operations on table
	@Autowired
	private UserRepository repo;

	// Object of encryption decryption class
	private CustomEncryptorDecryptor convert;

	// Getting object of logger
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	// to get record of user whose username and password is provided

	@GetMapping(path = "/login/{userName}/{password}")
	@HystrixCommand(fallbackMethod = "defaultUser")
	@ApiOperation(value = "retrieveUserFromParameters", nickname = "retrieveUserFromParameters")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public User findByuserName(@PathVariable String userName, @PathVariable String password) {
		convert = new CustomEncryptorDecryptor();
		User tmpUser = repo.findByUserNameAndUserPassword(userName, convert.encryptPassword(password));
		if (tmpUser.getUserId() != 0) {
			tmpUser.setUserPassword(convert.decryptPassword(tmpUser.getUserPassword()));
			return tmpUser;
		} else
			throw new UserNotFoundException("No user found");
	}

	// if exception occurs in findByuserName method this method will be called
	public User defaultUser(String userName, String password) {
		logger.info("Due to Invalid Username or Password, the fallbackmethod is called by Hystrix");
		return new User();
	}

	// Method to handle the User Registration Requests
	@PostMapping("/register")
	@HystrixCommand(fallbackMethod = "defaultRegister")
	@ApiOperation(value = "registerUser", nickname = "registerUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class),
			@ApiResponse(code = 400, message = "Bad Request", response = User.class) })
	public User registerUser(@RequestBody User user) throws Exception {
		convert = new CustomEncryptorDecryptor();
		String tempUserName = user.getUserName();
		if (tempUserName != null && !"".equals(tempUserName)) {
			User userObj = repo.findByUserName(tempUserName);
			if (userObj != null) {
				throw new UserNotFoundException("User with credentials" + tempUserName + "already exists");
			}
		}
		User userObj = null;
		user.setUserPassword(convert.encryptPassword(user.getUserPassword()));
		user.setAdmin(false);
		userObj = repo.save(user);
		userObj.setUserPassword(convert.decryptPassword(user.getUserPassword()));
		return userObj;
	}

	// if exception occurs in findByuserName method this method will be called
	// if will return default user details
	public User defaultRegister(User user) {
		logger.info("Due to invalid user registration details, the fallbackmethod is called by Hystrix");

		return new User();
	}

}
