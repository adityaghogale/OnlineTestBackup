package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.cg.controller.LoginTestProvider;
import com.cg.controller.UserLoginController;
import com.cg.entity.User;

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
		UserLoginController tmpCredentials = mock(UserLoginController.class);
		
		when(tmpCredentials.findByuserName("adi", "adi"))
				.thenReturn(new User(101, "adi", "adi", "adi@gmail.com", 0, true));
		
		LoginTestProvider tmpTestData = new LoginTestProvider(tmpCredentials);
		User tmpUser = tmpTestData.getDataSuplier().findByuserName("adi", "adi");
		// verifying expected and actual output
		assertEquals(101, tmpUser.getUserId());
	}

	// For invalid password during login
	@Test
	public void testInvalidPassword() {
		// creating mock object of service
		UserLoginController tmpCredentials = mock(UserLoginController.class);
		
		when(tmpCredentials.findByuserName("adi", "add")).thenReturn(new User());
		
		LoginTestProvider tmpTestData = new LoginTestProvider(tmpCredentials);
		User tmpUser = tmpTestData.getDataSuplier().findByuserName("adi", "add");
		// verifying expected and actual output
		assertNotEquals(101, tmpUser.getUserId());
	}

	//for invalid user_id and password
	@Test
	public void testInvalidCrentials() {
		// creating mock object of service
		UserLoginController tmpCredentials = mock(UserLoginController.class);
		
		when(tmpCredentials.findByuserName("add", "add")).thenReturn(new User());
		
		LoginTestProvider tmpTestData = new LoginTestProvider(tmpCredentials);
		User tmpUser = tmpTestData.getDataSuplier().findByuserName("add", "add");
		// verifying expected and actual output
		assertEquals(0, tmpUser.getUserId());
	}

}
