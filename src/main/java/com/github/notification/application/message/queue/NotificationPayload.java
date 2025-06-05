package com.github.notification.application.message.queue;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.notification.core.domain.enumerated.NotificationType;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationPayload {

    private UUID userId;

    private String message;

    private NotificationType notificationType;

    public NotificationPayload() {
    }

    public NotificationPayload(UUID userId, String message, NotificationType notificationType) {
        this.userId = userId;
        this.message = message;
        this.notificationType = notificationType;
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

    @Override
    public String toString() {
        return "NotificationPayload{" +
                "userId=" + userId +
                "message='" + message + '\'' +
                ", notificationType=" + notificationType +
                '}';
    }
}
