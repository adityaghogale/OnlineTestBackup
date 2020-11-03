package com.cg.security;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//Custom encryptor and decryptor to encode and decode password
public class CustomEncryptorDecryptor {

	//key for encryption and decryption
	private static final int key=5; 
	
	//default constructor
	public CustomEncryptorDecryptor() {
		super();
	}

	//method to encrypt password
	public String encryptPassword(String tmpPassword) {
		//converting string to character array for encryption
		char[] tmpCharArray=tmpPassword.toCharArray();
		
		//calculating length of string
		int passLength=tmpPassword.length();
		
		//applying key on string
		for(int i=0;i<passLength;i++) {
			tmpCharArray[i]+=key;
		}
		
		//return encrypted password 
		return String.valueOf(tmpCharArray);
	}
	
	
	//to decrypt encrypted password from table 
	public String decryptPassword(String tmpPassword) {
		//converting string to character array for encryption
		char[] tmpCharArray=tmpPassword.toCharArray();
		
		//calculating length of string
		int passLength=tmpPassword.length();
		
		//applying key on string
		for(int i=0;i<passLength;i++) {
			tmpCharArray[i]-=key;
		}
		
		//return decrypted password 
		return String.valueOf(tmpCharArray);
	}
}
