package com.penny.demo.penny.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.penny.demo.penny.model.NotificationType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="notification")
public class Notification {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int notificationId;
    @JsonIgnore
    private int userRefId;
    private NotificationType type;
    private String notificationMsg;
}
