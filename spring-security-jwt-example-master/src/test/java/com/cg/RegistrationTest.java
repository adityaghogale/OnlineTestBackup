package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
class RegistrationTest {

	//validate registration with proper values
	@Test
	void validRegistration() {
		//creating user object to save
		User tmpUser=new User(101,"adi","adi","adi@gmail.com",0,true);
		
		//creating mock of service
		TestDataProvierService tmpCredentials= mock(TestDataProvierService.class);
		
		when(tmpCredentials.userRegister(tmpUser)).thenReturn(tmpUser);
		
		TestInstanceProvider tmpReg=new TestInstanceProvider(tmpCredentials);
		User result=tmpReg.getService().userRegister(tmpUser);
		
		//validate expected and actual output
		assertEquals(101,result.getId());
	}

}
