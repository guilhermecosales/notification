package com.github.notification.core.service;

import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistence;
import com.github.notification.core.port.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    private final NotificationPersistence notificationPersistence;

    public NotificationServiceImpl(NotificationPersistence notificationPersistence) {
        this.notificationPersistence = notificationPersistence;
    }

    @Override
    public NotificationDomain saveNotification(NotificationDomain notificationDomain) {
        return notificationPersistence.save(notificationDomain);
    }

    @Override
    public List<NotificationDomain> getNotifications() {
        return notificationPersistence.findAll();
    }
}
