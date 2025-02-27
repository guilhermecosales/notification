package com.github.notification.core.service;

import com.github.notification.adapter.outbound.service.EmailNotificationService;
import com.github.notification.adapter.outbound.service.PushNotificationService;
import com.github.notification.adapter.outbound.service.SmsNotificationService;
import com.github.notification.core.domain.enumerated.NotificationType;
import com.github.notification.core.port.NotificationSenderService;

import java.util.Map;

public class NotificationSenderFactory {

    private final Map<NotificationType, NotificationSenderService> notificationServices;

    public NotificationSenderFactory(SmsNotificationService smsService,
                                     EmailNotificationService emailService,
                                     PushNotificationService pushService) {
        this.notificationServices = Map.of(
                NotificationType.SMS, smsService,
                NotificationType.EMAIL, emailService,
                NotificationType.PUSH, pushService
        );
    }

    public NotificationSenderService getNotificationSenderService(NotificationType type) {
        return notificationServices.get(type);
    }

}
