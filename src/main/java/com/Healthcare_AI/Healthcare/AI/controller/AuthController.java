package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.entity.User;
import com.Healthcare_AI.Healthcare.AI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular frontend
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        userRepository.save(user);

        // ✅ Send JSON response
        return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully!"));
    }

}
