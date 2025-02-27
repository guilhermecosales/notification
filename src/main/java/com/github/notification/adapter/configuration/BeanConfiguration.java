package com.github.notification.adapter.configuration;

import com.github.notification.core.port.NotificationPersistence;
import com.github.notification.core.port.NotificationService;
import com.github.notification.core.service.NotificationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    NotificationService notificationService(NotificationPersistence notificationPersistence) {
        return new NotificationServiceImpl(notificationPersistence);
    }

}
