package com.github.notification.core.service;

import com.github.notification.core.domain.enumerated.NotificationType;
import com.github.notification.core.port.NotificationSenderService;

public class NotificationTypeHandler {

    private final NotificationSenderFactory notificationSenderFactory;

    public NotificationTypeHandler(NotificationSenderFactory notificationSenderFactory) {
        this.notificationSenderFactory = notificationSenderFactory;
    }

    public void send(NotificationType type, String message) {
        NotificationSenderService service = notificationSenderFactory.getNotificationSenderService(type);

        if (service != null) {
            service.send(message);
        } else {
            throw new IllegalArgumentException("Notification type not supported: " + type);
        }
    }

}
