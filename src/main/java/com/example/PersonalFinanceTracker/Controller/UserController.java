package com.example.PersonalFinanceTracker.Controller;

import com.example.PersonalFinanceTracker.DTO.LoginResponse;
import com.example.PersonalFinanceTracker.DTO.UserRequest;
import com.example.PersonalFinanceTracker.Entity.User;
import com.example.PersonalFinanceTracker.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a new user", description = "")
    @PostMapping
    public String createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);

        return "User created: " + newUser.getName();
    }

    @Operation(summary = "Get all users", description = "")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @Operation(summary = "Login user", description = "")
    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody UserRequest user) {
        return userService.loginUser(user);
    }

}
