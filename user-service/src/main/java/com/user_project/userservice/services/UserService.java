package com.user_project.userservice.services;

import com.user_project.userservice.DAO.UserDAO;
import com.user_project.userservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public List<User> getAllUsers() {
        System.out.println(" In SERvice");
       return userDAO.findAll();
    }

    public User getUser(String username) {
        return userDAO.findById(username).stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
    }

    public User addUser(User user) {
        this.userDAO.save(user);
        return user;
    }
}
