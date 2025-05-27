package com.example.PersonalFinanceTracker.Service;

import com.example.PersonalFinanceTracker.DTO.LoginResponse;
import com.example.PersonalFinanceTracker.DTO.UserRequest;
import com.example.PersonalFinanceTracker.Entity.User;
import com.example.PersonalFinanceTracker.Repository.UserRepository;
import com.example.PersonalFinanceTracker.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service: Business logic. Process data and make calls to repository
// It is an intermediary: controller <=> service <=> repository

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    public UserService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public LoginResponse loginUser(UserRequest user) {
        User checkUser = userRepository.findByEmail(user.getEmail());

        if (checkUser == null || !checkUser.getEmail().equals(user.getEmail())) {
            throw new RuntimeException("Invalid email or password");
        }

        LoginResponse response = new LoginResponse();
        response.setToken(jwtUtil.generateToken(checkUser.getId()));
        response.setMessage("Login successful");

        return response;
    }

}
