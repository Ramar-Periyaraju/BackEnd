package com.healthcare.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByEmail(String email);
    User findByUsername(String username); 

    
} 