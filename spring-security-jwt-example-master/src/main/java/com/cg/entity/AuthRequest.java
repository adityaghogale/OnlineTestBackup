package com.cg.entity;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//This class is used to pass username and password to various classes
public class AuthRequest {

    private String userName;
    private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}
