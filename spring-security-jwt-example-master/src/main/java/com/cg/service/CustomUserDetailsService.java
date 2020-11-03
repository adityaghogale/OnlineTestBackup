package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cg.entity.User;
import com.cg.repository.UserRepository;

import java.util.ArrayList;

/**
 * 
 * @author Aditya Ghogale
 *
 */
//Service layer for user table
@Service
public class CustomUserDetailsService implements UserDetailsService {
	//object for repository to perform operations
    @Autowired
    private UserRepository repository;

    //this method will fetch user info. from table by provided username and password
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
    }
}
