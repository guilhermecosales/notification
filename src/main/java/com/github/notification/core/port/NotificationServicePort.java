package com.github.notification.core.port;

import com.github.notification.core.domain.NotificationDomain;

public interface NotificationServicePort {

    NotificationDomain saveNotification(NotificationDomain notificationDomain);

}
