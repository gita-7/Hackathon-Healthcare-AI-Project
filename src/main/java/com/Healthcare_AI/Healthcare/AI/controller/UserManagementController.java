package com.Healthcare_AI.Healthcare.AI.controller;

import com.Healthcare_AI.Healthcare.AI.dto.LoginRequest;
import com.Healthcare_AI.Healthcare.AI.dto.LoginResponse;
import com.Healthcare_AI.Healthcare.AI.entity.User;
import com.Healthcare_AI.Healthcare.AI.repository.UserRepository;
import com.Healthcare_AI.Healthcare.AI.service.AuthService;
import com.Healthcare_AI.Healthcare.AI.service.UserService;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200") // Allow Angular app access
public class UserManagementController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    // User Registration Endpoint
    @CrossOrigin
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody User user) {
        userRepository.save(user);

        // ✅ Send JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully!");

        return ResponseEntity.ok(response);
    }

    //@CrossOrigin
  //  @PostMapping("/login")
//    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
//        if (loginRequest == null || loginRequest.getUsername() == null || loginRequest.getPassword() == null) {
//            return ResponseEntity.badRequest().body(Map.of("error", "Invalid request data"));
//        }
//        LoginResponse response = null;
//        if (response == null) {
//            return ResponseEntity.status(401).body(null); // Unauthorized if authentication fails
//        }
//        // Send role along with token
//        Map<String, Object> responseBody = new HashMap<>();
//        responseBody.put("token", response.getToken());
//        responseBody.put("role", response.getRole());  // ✅ Send role
//
//
//        response = userService.authenticateUser(loginRequest);
//
//        if (response == null) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid username or password"));
//        }
//
//        return ResponseEntity.ok(response);
//        //return ResponseEntity.ok(responseBody);
//    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println("Received Login Request: " + request.getEmailID() + " | " + request.getPassword());

        if (request.getEmailID() == null || request.getPassword() == null) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", "Invalid request data"));
        }

        Optional<User> response = authService.authenticateUser(request.getEmailID(), request.getPassword());
        if (response != null && response.isPresent()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("userData", response.get());  // ✅ Now this works
            return ResponseEntity.ok(responseBody);
        }
        return ResponseEntity.status(401).body(null);
    }

    // Get User Profile
    @CrossOrigin
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users); // ✅ Return JSON list of users
    }

}
