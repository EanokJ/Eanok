package com.penny.demo.penny.serviceimpl;

import com.penny.demo.penny.entity.Notification;
import com.penny.demo.penny.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    public List<Notification> getNotification(){
        return notificationRepository.findAll();
    }
}
