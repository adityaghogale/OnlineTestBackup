package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.cg.entity.User;
import com.cg.service.TestDataProvierService;
import com.cg.service.TestInstanceProvider;

/**
 * 
 * @author Aditya Ghogale
 *
 */

class LoginTest {

	
	// To validate login for a valid user
	@Test
	public void testValidLogin() {
		// creating mock object of service
		TestDataProvierService tmpCredentials = mock(TestDataProvierService.class);
		
		when(tmpCredentials.userLogin("adi", "adi"))
				.thenReturn(new User(101, "adi", "adi", "adi@gmail.com", 0, true));
		
		TestInstanceProvider tmpTestData = new TestInstanceProvider(tmpCredentials);
		User tmpUser = tmpTestData.getService().userLogin("adi", "adi");
		// verifying expected and actual output
		assertEquals(101, tmpUser.getId());
	}

	// For invalid password during login
	@Test
	public void testInvalidPassword() {
		// creating mock object of service
		TestDataProvierService tmpCredentials = mock(TestDataProvierService.class);
		
		when(tmpCredentials.userLogin("adi", "add")).thenReturn(new User());
		
		TestInstanceProvider tmpTestData = new TestInstanceProvider(tmpCredentials);
		User tmpUser = tmpTestData.getService().userLogin("adi", "add");
		// verifying expected and actual output
		assertNotEquals(101, tmpUser.getId());
	}

	//for invalid user_id and password
	@Test
	public void testInvalidCrentials() {
TestDataProvierService tmpCredentials = mock(TestDataProvierService.class);
		
		when(tmpCredentials.userLogin("adi", "add")).thenReturn(new User());
		
		TestInstanceProvider tmpTestData = new TestInstanceProvider(tmpCredentials);
		User tmpUser = tmpTestData.getService().userLogin("adi", "add");
		// verifying expected and actual output
		assertNotEquals(101, tmpUser.getId());
	}

}
