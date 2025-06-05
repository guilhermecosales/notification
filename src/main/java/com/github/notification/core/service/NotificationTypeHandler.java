package com.github.notification.core.service;

import com.github.notification.core.domain.enumerated.NotificationType;

public class NotificationTypeHandler {

    private final NotificationSenderFactory notificationSenderFactory;

    public NotificationTypeHandler(NotificationSenderFactory notificationSenderFactory) {
        this.notificationSenderFactory = notificationSenderFactory;
    }

    public void send(NotificationType type, String message) {
        notificationSenderFactory.getNotificationSenderService(type).send(message);
    }

}
