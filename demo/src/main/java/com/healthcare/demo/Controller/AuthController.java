package com.healthcare.demo.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Service.UserService;

import org.springframework.http.HttpStatus;


@RestController
public class AuthController {
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String rawPassword = requestBody.get("password");

        // Retrieve encrypted password from the database based on email
        String encryptedPassword = UserService.getEncryptedPasswordByEmail(email);

        if (encryptedPassword != null && UserService.verifyPassword(rawPassword, encryptedPassword)) {
            // Authentication successful
            return ResponseEntity.ok().build();
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}