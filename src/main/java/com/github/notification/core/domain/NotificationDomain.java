package com.github.notification.core.domain;

import com.github.notification.core.domain.enumerated.NotificationStatus;
import com.github.notification.core.domain.enumerated.NotificationType;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationDomain {

    private UUID notificationId;

    private UUID userId;

    private String message;

    private NotificationType notificationType;

    private NotificationStatus notificationStatus;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public NotificationDomain() {
    }

    public NotificationDomain(UUID notificationId, UUID userId, String message, NotificationType notificationType, NotificationStatus notificationStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.notificationType = notificationType;
        this.notificationStatus = notificationStatus;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(UUID notificationId) {
        this.notificationId = notificationId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

}
