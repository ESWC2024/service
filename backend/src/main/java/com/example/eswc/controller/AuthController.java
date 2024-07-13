package com.example.eswc.controller;

import com.example.eswc.model.User;
import com.example.eswc.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
    authService.signup(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
}

@PostMapping("/login")
public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
    String token = authService.login(username, password);
    if (token == null) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
    return ResponseEntity.ok(token);
}

@PutMapping("/change-password")
public ResponseEntity<String> changePassword(@RequestParam String username, @RequestParam String oldPassword,
@RequestParam String newPassword) {
    boolean changed = authService.changePassword(username, oldPassword, newPassword);
    if (!changed) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to change password");
    }
    return ResponseEntity.ok("Password changed successfully");
}

}

