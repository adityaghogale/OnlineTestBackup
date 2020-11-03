package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//User class with attributes to create table in database
@Entity
public class User {
	//class attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column
	private String userName;
	@Column
	private String userPassword;
	@Column
	private String email;
	@Column
	private int testId;
	@Column
	private boolean isAdmin;
	
	//getters and setters
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = 0;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = Boolean.FALSE;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//constructor with all fields in it
	public User(int userId, String userName, String userPassword, String email, int testId, boolean isAdmin) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.email = email;
		this.testId = testId;
		this.isAdmin = isAdmin;
	}
	
	//default constructor
	public User() {
		super();
	}
	
	//toString method to display user details
	@Override
	public String toString() {
		return "Employee [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", email="
				+ email + ", testId=" + testId + ", isAdmin=" + isAdmin + "]";
	}
	
		
}


