package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.UserDTO;
import com.Healthcare_AI.Healthcare.AI.entity.User;
import com.Healthcare_AI.Healthcare.AI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User registerUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        //user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> authenticateUser(String email, String password) {
        Optional<User> user = Optional.empty();
        try {
            user = userRepository.findByEmail(email);
            if (user != null && user.isPresent()) {
                return user;
            } else {
                return Optional.empty();
            }
        } catch (Exception ex) {
            return Optional.empty();
        }
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
