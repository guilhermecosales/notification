package com.github.notification.core.service;

import com.github.notification.core.domain.enumerated.NotificationType;
import com.github.notification.core.port.NotificationSenderService;

import java.util.Map;
import java.util.Optional;

public class NotificationSenderFactory {

    private final Map<NotificationType, NotificationSenderService> notificationServices;

    public NotificationSenderFactory(Map<NotificationType, NotificationSenderService> notificationServices) {
        this.notificationServices = notificationServices;
    }

    public NotificationSenderService getNotificationSenderService(NotificationType type) {
        return Optional.ofNullable(notificationServices.get(type))
                .orElseThrow(() -> new IllegalArgumentException("Notification type not supported: " + type));
    }

}
