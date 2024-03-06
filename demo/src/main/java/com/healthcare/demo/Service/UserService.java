package com.healthcare.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.Entity.User;
import com.healthcare.demo.Repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserService {

    @Autowired
    private static PasswordEncoder passwordEncoder; 
    
    @Autowired
    private static UserRepo userRepo;

    public User saveDetails(User user) { 
        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepo.save(user);
    }

    public static String getEncryptedPasswordByEmail(String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            return user.getPassword(); // Assuming the password is stored as a String in the database
        }
        return null;
    }

    public static boolean verifyPassword(String rawPassword, String encryptedPassword) {
        return passwordEncoder.matches(rawPassword, encryptedPassword);
    }
}
