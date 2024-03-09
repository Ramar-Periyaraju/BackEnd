package com.healthcare.demo.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Entity.UserInfo;
import com.healthcare.demo.Repository.UserInfoRepository;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SignInController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserInfoRepository userRepository;

    @Autowired
    public SignInController(BCryptPasswordEncoder passwordEncoder, UserInfoRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody SignInRequest signInRequest) {
        // Retrieve user credentials from the request
        String username = signInRequest.getUsername();
        String rawPassword = signInRequest.getPassword();

        // Retrieve user info from the database based on the username
        Optional<UserInfo> userOptional = userRepository.findByName(username);

        if (userOptional.isPresent()) {
            UserInfo user = userOptional.get();
            String hashedPasswordFromDatabase = user.getPassword();

            if (passwordEncoder.matches(rawPassword, hashedPasswordFromDatabase)) {
                return "Sign-in successful";
            }
        }

        return "Invalid credentials";
    }

    static class SignInRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
