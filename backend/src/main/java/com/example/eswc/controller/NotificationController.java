package com.example.eswc.controller;

import com.example.eswc.model.Notification;
import com.example.eswc.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestParam String message) {
    notificationService.sendNotification(message);
    return ResponseEntity.status(HttpStatus.CREATED).body("Notification sent successfully!");
}

@GetMapping
public ResponseEntity<List<Notification>> getAllNotifications() {
    List<Notification> notifications = notificationService.getAllNotifications();
    return ResponseEntity.ok(notifications);
}
}
