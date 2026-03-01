package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String email, String password) {
        // Validate input
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username must not be empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email must not be empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password must not be empty");
        }
        
        // Check if user already exists
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        // Create and save new user
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        
        return userRepository.save(user);
    }
    
}
