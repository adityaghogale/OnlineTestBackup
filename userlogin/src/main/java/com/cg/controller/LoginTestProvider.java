package com.cg.controller;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class LoginTestProvider {

	//declaration of controller object
	private UserLoginController dataSuplier;
	
	//constructor with fields
	public LoginTestProvider(UserLoginController dataSuplier) {
		super();
		this.dataSuplier = dataSuplier;
	}
	
	//getters and setters
	public UserLoginController getDataSuplier() {
		return dataSuplier;
	}

	public void setDataSuplier(UserLoginController dataSuplier) {
		this.dataSuplier = dataSuplier;
	}
	
	
}
