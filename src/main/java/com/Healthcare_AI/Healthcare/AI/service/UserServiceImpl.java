package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.LoginRequest;
import com.Healthcare_AI.Healthcare.AI.dto.LoginResponse;
import com.Healthcare_AI.Healthcare.AI.entity.User;
import com.Healthcare_AI.Healthcare.AI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(User user) {
        // Encrypt password before saving
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully!";
    }

    @Override
    public LoginResponse authenticateUser(LoginRequest loginRequest) {
        User user = userRepository.findByName(loginRequest.getEmailID());
//
//        if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
//            LoginResponse response = new LoginResponse();
//            response.setToken("JWT-TOKEN-PLACEHOLDER");
//            response.setMessage("Login successful!");
//            return response;
//        }

        return null; // Authentication failed
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
