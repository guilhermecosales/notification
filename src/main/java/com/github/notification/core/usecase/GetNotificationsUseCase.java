package com.github.notification.core.usecase;

import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistence;

import java.util.List;

public class GetNotificationsUseCase {

    private final NotificationPersistence notificationPersistence;

    public GetNotificationsUseCase(NotificationPersistence notificationPersistence) {
        this.notificationPersistence = notificationPersistence;
    }

    public List<NotificationDomain> execute() {
        return notificationPersistence.findAll();
    }
}
