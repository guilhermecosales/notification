package com.github.notification.adapter.configuration;

import com.github.notification.adapter.outbound.service.EmailNotificationService;
import com.github.notification.adapter.outbound.service.PushNotificationService;
import com.github.notification.adapter.outbound.service.SmsNotificationService;
import com.github.notification.core.port.NotificationPersistence;
import com.github.notification.core.port.NotificationService;
import com.github.notification.core.service.NotificationSenderFactory;
import com.github.notification.core.service.NotificationServiceImpl;
import com.github.notification.core.service.NotificationTypeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    NotificationService notificationService(NotificationPersistence notificationPersistence) {
        return new NotificationServiceImpl(notificationPersistence);
    }

    @Bean
    NotificationSenderFactory notificationSenderFactory(
            SmsNotificationService smsNotificationService,
            EmailNotificationService emailNotificationService,
            PushNotificationService pushNotificationService
    ) {
        return new NotificationSenderFactory(
                smsNotificationService,
                emailNotificationService,
                pushNotificationService
        );
    }

    @Bean
    NotificationTypeHandler notificationTypeHandler(NotificationSenderFactory notificationSenderFactory) {
        return new NotificationTypeHandler(notificationSenderFactory);
    }

}
