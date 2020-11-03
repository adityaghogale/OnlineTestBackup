package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.User;

/**
 * 
 * @author Aditya Ghogale
 *
 */
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUserName(String username);
}
