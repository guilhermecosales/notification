package com.github.notification.core.usecase;

import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistence;

public class SaveNotificationUseCase {

    private final NotificationPersistence notificationPersistence;

    public SaveNotificationUseCase(NotificationPersistence notificationPersistence) {
        this.notificationPersistence = notificationPersistence;
    }

    public NotificationDomain execute(NotificationDomain notificationDomain) {
        return notificationPersistence.save(notificationDomain);
    }

}
