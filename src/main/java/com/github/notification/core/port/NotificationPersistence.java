package com.github.notification.core.port;

import com.github.notification.core.domain.NotificationDomain;

import java.util.List;

public interface NotificationPersistence {

    NotificationDomain save(NotificationDomain notificationDomain);

    List<NotificationDomain> findAll();

}
