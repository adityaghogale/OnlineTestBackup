package com.cg.entity;

/**
 * 
 * @author Aditya Ghogale
 *
 */

//User entity
public class User {

	//class attributes
	private int userId;
	private String userName;
	private String userPassword;
	private String email;
	private int testId;
	private boolean isAdmin;
	
	//getters and setters
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
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	//constructor with fields
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
	
	//to display object in custom manner
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", email="
				+ email + ", testId=" + testId + ", isAdmin=" + isAdmin + "]";
	}
	
	
}
