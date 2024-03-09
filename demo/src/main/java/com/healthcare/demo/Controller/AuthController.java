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

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        String rawPassword = requestBody.get("password");

        String encryptedPassword = userService.getEncryptedPasswordByEmail(email);

        if (encryptedPassword != null && userService.verifyPassword(rawPassword, encryptedPassword)) {
            // Authentication successful
            return ResponseEntity.ok().body("Authentication successful");
        } else {
            // Authentication failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed!!");
        }
    }
}
