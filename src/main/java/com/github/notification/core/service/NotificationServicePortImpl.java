package com.github.notification.core.service;

import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistencePort;
import com.github.notification.core.port.NotificationServicePort;
import org.springframework.stereotype.Service;

@Service
public class NotificationServicePortImpl implements NotificationServicePort {

    private final NotificationPersistencePort notificationPersistencePort;

    public NotificationServicePortImpl(NotificationPersistencePort notificationPersistencePort) {
        this.notificationPersistencePort = notificationPersistencePort;
    }

    @Override
    public NotificationDomain saveNotification(NotificationDomain notificationDomain) {
        return notificationPersistencePort.save(notificationDomain);
    }
}
