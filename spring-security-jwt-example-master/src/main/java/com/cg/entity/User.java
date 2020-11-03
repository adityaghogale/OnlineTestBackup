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

//Entity class for user
@Entity
public class User {
	
	//attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private int testId;
    @Column
    private boolean isAdmin;
    
    //getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		this.isAdmin = false;
	}
	
	//Constructor with fields
	public User(int id, String userName, String password, String email, int testId, boolean isAdmin) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.testId = testId;
		this.isAdmin = isAdmin;
	}
	
	//default constructor
	public User() {
		super();
	}
    
    
}
