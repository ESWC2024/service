package com.example.eswc.service;

import com.example.eswc.model.Notification;
import com.example.eswc.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public void sendNotification(String message) {
    Notification notification = new Notification(message);
    notificationRepository.save(notification);
}

public List<Notification> getAllNotifications() {
    return notificationRepository.findAll();
}
}
