package com.healthcare.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.Entity.User;
import com.healthcare.demo.Service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {

    @Autowired
    private UserService userService ;

@CrossOrigin(origins = "http://localhost:4200")
@PostMapping("/addUser")
public User postDetails(@RequestBody User user) {
    
    return userService.saveDetails(user);
}
    
}
