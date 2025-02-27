package com.github.notification.core.port;

import com.github.notification.core.domain.NotificationDomain;

import java.util.List;

public interface NotificationService {

    NotificationDomain saveNotification(NotificationDomain notificationDomain);

    List<NotificationDomain> getNotifications();

}
