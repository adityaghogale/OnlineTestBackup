package com.cg.controller;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public class RegistrationTestProvider {

	//declaration of controller object
	private RegistrationController dataSupplier;

	//constructor with fields
	public RegistrationTestProvider(RegistrationController dataSupplier) {
		super();
		this.dataSupplier = dataSupplier;
	}

	//getters and setters
	public RegistrationController getDataSupplier() {
		return dataSupplier;
	}

	public void setDataSupplier(RegistrationController dataSupplier) {
		this.dataSupplier = dataSupplier;
	}
	
	
}
