package com.example.PersonalFinanceTracker.Service;

import com.example.PersonalFinanceTracker.Entity.User;
import com.example.PersonalFinanceTracker.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service: Business logic. Process data and make calls to repository
// It is an intermediary: controller <=> service <=> repository

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
