package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.Entities.User;
import com.example.PersonalFinanceTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles incoming HTTP request (REST API) and return responses

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello world!";
    }

    @PostMapping("/user")
    public String createUser(@RequestBody User user) {

        userService.createUser(user);

        return "User created";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
