package com.user_project.userservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/public")
public class HomeController {

    @GetMapping(value = "/home")
    public String home() {
        return "this is home page";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "this is login page";
    }

    @GetMapping(value = "/register")
    public String register() {
        return "this is register page";
    }


}
