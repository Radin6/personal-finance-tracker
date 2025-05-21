package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.Entity.User;
import com.example.PersonalFinanceTracker.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Handles incoming HTTP request (REST API) and return responses

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);

        return "User created: " + newUser.getName();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
