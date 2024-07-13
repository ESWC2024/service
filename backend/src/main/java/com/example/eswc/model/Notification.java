package com.example.eswc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private LocalDateTime createdAt;

    // Constructors, getters, setters

    public Notification() {
        this.createdAt = LocalDateTime.now();
    }

    public Notification(String message) {
    this.message = message;
    this.createdAt = LocalDateTime.now();
}

// Getters and setters
public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getMessage() {
    return message;
}

public void setMessage(String message) {
    this.message = message;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}
}
