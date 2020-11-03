package com.cg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.AuthRequest;
import com.cg.entity.User;
import com.cg.exception.UserNotFoundException;
import com.cg.repository.UserRepository;
import com.cg.util.JwtUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @author Aditya Ghogale
 *
 */
@RestController
@RequestMapping("/testapp")
public class LoginServiceController {

	// reference of repository
	@Autowired
	private UserRepository proxy;

	// reference of util which is used for token related operations
	@Autowired
	private JwtUtil jwtUtil;

	// reference of authentication manager
	@Autowired
	private AuthenticationManager authenticationManager;

	// to store username
	private String loginUserName = null;

	// regular expression to validate email
	private String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
	// Getting object of logger
		private static final Logger logger = LoggerFactory.getLogger(LoginServiceController.class);

	// simple methods to call using token
	@GetMapping("/hello")
	public String welcome() {
		logger.info("user "+loginUserName+" just logged in");
		return "Welcome " + loginUserName + " to my First JWT Token example after authentication part !!";
	}

	// login method
	@ApiOperation(value = "retrieveUserFromParameters", nickname = "retrieveUserFromParameters")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			                @ApiResponse(code = 500, message = "Failure", response = User.class) })
	@PostMapping("/user/login")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		if("".equals(authRequest.getUserName()))throw new UserNotFoundException("Username cannot be empty");
		if("".equals(authRequest.getPassword()))throw new UserNotFoundException("Password cannot be empty");
		try {
			// it will communicate with table and validate provided username and password
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));

			// UsernamePasswordAuthenticationToken is an inbuilt class.
			// above code will validate username and password
		} catch (Exception ex) {
			logger.info("Invalid username and password");
			throw new Exception("inavalid username/password");
		}

		// store username record after validation
		loginUserName = authRequest.getUserName();

		// generate token using method in JwtUtil and return token
		return jwtUtil.generateToken(authRequest.getUserName());
	}

	// to register new user in table
	@ApiOperation(value = "retrieveUserFromParameters", nickname = "retrieveUserFromParameters")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	@PostMapping("/user/register")
	public User registerUser(@RequestBody User user) throws UserNotFoundException {
		User tmpUser;
		// it will check if username is already present in database or not.If yes then
		// throw error
		if (proxy.findByUserName(user.getUserName()) != null)
			throw new UserNotFoundException("This UserName is already taken");

		// will check if provided username and password are null or not. If yes then
		// throw error
		if ("".equals(user.getUserName()) || "".equals(user.getPassword()))
			throw new UserNotFoundException("User details cannot be empty");

		// validate the provided email with regular expression
		if (!(user.getEmail().matches(emailRegex)))
			throw new UserNotFoundException("User email must be in proper format");

		// initially user wont have any test assign to him. So its value will be 0
		user.setTestId(0);

		// save user to table
		tmpUser = proxy.save(user);
		return tmpUser;

	}
}
