package com.github.notification.core.port;

import com.github.notification.core.domain.NotificationDomain;

public interface NotificationPersistencePort {

    NotificationDomain save(NotificationDomain notificationDomain);

}
