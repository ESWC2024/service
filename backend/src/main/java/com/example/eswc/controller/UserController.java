package com.example.eswc.controller;

import com.example.eswc.model.User;
import com.example.eswc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
    userService.registerUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully!");
}

@GetMapping("/{username}")
public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
    User user = userService.getUserByUsername(username);
    if (user == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(user);
}

@GetMapping
public ResponseEntity<List<User>> getAllUsers() {
    List<User> users = userService.getAllUsers();
    return ResponseEntity.ok(users);
}

@PutMapping("/{id}")
public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
    boolean updated = userService.updateUser(id, updatedUser);
    if (!updated) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("User updated successfully");
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteUser(@PathVariable Long id) {
    boolean deleted = userService.deleteUser(id);
    if (!deleted) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok("User deleted successfully");
}
}
