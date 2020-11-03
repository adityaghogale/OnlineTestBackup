package com.cg.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.User;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//communicate with login data provider for login function
@FeignClient(name="logindataprovider")
@RibbonClient(name="logindataprovider")
public interface LoginServiceProxy {
	
	@GetMapping(path="/login/{userName}/{userPassword}")
	public User findByuserName(@PathVariable String userName,@PathVariable String userPassword);
	
	//method that will communicate with controller method at data provider
		@PostMapping("/register")
		public User registerUser(@RequestBody User user);
}
