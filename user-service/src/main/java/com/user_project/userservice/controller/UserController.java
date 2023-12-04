package com.user_project.userservice.controller;

import com.user_project.userservice.entity.User;
import com.user_project.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    @GetMapping(value = "/")
    public List<User> getAllUsers() {
        System.out.println(" In Controller");
        return userService.getAllUsers();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") String username) {
        System.out.println("output ");
        return userService.getUser(username);
    }

    @PostMapping(value = "/")
    public User addUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return user;
    }



}
