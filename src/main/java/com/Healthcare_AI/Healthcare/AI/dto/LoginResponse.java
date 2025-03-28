package com.Healthcare_AI.Healthcare.AI.dto;

public class LoginResponse {
    private String token;
    private String message;

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    private String role;  // ✅ Add role field

    public LoginResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getRole() {  // ✅ Add getter for role
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
