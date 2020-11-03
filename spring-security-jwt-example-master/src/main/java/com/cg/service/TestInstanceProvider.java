package com.cg.service;

/**
 * 
 * @author Aditya Ghogale
 *
 */
//provides instance of service for testing
public class TestInstanceProvider {

	private TestDataProvierService service;

	public TestDataProvierService getService() {
		return service;
	}

	public void setService(TestDataProvierService service) {
		this.service = service;
	}

	public TestInstanceProvider(TestDataProvierService service) {
		super();
		this.service = service;
	}
	
}