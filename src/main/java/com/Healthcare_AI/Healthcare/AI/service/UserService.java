package com.Healthcare_AI.Healthcare.AI.service;

import com.Healthcare_AI.Healthcare.AI.dto.LoginRequest;
import com.Healthcare_AI.Healthcare.AI.dto.LoginResponse;
import com.Healthcare_AI.Healthcare.AI.entity.User;

public interface UserService {
    String registerUser(User user);
    LoginResponse authenticateUser(LoginRequest loginRequest);
    User getUserById(Long id);
}
