package com.penny.demo.penny.repository;

import com.penny.demo.penny.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    public List<Notification> findAllByUserRefId(int userRefId);
}
