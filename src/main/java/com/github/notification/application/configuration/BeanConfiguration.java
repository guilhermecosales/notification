package com.github.notification.application.configuration;

import com.github.notification.adapter.outbound.sender.EmailNotificationService;
import com.github.notification.adapter.outbound.sender.PushNotificationService;
import com.github.notification.adapter.outbound.sender.SmsNotificationService;
import com.github.notification.core.domain.enumerated.NotificationType;
import com.github.notification.core.port.NotificationPersistence;
import com.github.notification.core.port.NotificationSenderService;
import com.github.notification.core.service.NotificationSenderFactory;
import com.github.notification.core.service.NotificationTypeHandler;
import com.github.notification.core.usecase.GetNotificationsUseCase;
import com.github.notification.core.usecase.SaveNotificationUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
public class BeanConfiguration {

    private final SmsNotificationService smsNotificationService;
    private final EmailNotificationService emailNotificationService;
    private final PushNotificationService pushNotificationService;

    public BeanConfiguration(
            SmsNotificationService smsNotificationService,
            EmailNotificationService emailNotificationService,
            PushNotificationService pushNotificationService
    ) {
        this.smsNotificationService = smsNotificationService;
        this.emailNotificationService = emailNotificationService;
        this.pushNotificationService = pushNotificationService;
    }

    @Bean
    public NotificationSenderFactory notificationSenderFactory() {
        Map<NotificationType, NotificationSenderService> notificationServices = new EnumMap<>(NotificationType.class);
        notificationServices.put(NotificationType.SMS, smsNotificationService);
        notificationServices.put(NotificationType.EMAIL, emailNotificationService);
        notificationServices.put(NotificationType.PUSH, pushNotificationService);

        return new NotificationSenderFactory(notificationServices);
    }

    @Bean
    public NotificationTypeHandler notificationTypeHandler(NotificationSenderFactory notificationSenderFactory) {
        return new NotificationTypeHandler(notificationSenderFactory);
    }

    @Bean
    public GetNotificationsUseCase getNotificationsUseCase(NotificationPersistence notificationPersistence) {
        return new GetNotificationsUseCase(notificationPersistence);
    }

    @Bean
    public SaveNotificationUseCase saveNotificationUseCase(NotificationPersistence notificationPersistence) {
        return new SaveNotificationUseCase(notificationPersistence);
    }

}
