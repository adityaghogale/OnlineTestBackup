package com.cg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cg.entity.User;

/**
 * 
 * @author Aditya Ghogale
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {
	
	// to fetch user record using username and password
	public User findByUserNameAndUserPassword(@Param("userName") String userName,@Param("password") String password);
	
	// to fetch user record using username
	public User findByUserName(@Param("userName") String userName);
}
