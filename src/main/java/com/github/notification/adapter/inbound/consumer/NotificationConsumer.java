package com.github.notification.adapter.inbound.consumer;

import com.github.notification.adapter.dto.NotificationPayload;
import com.github.notification.core.service.NotificationTypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final Logger log = LoggerFactory.getLogger(NotificationConsumer.class);

    private final NotificationTypeHandler notificationTypeHandler;

    public NotificationConsumer(NotificationTypeHandler notificationTypeHandler) {
        this.notificationTypeHandler = notificationTypeHandler;
    }

    @RabbitListener(queues = "notification-queue")
    public void consume(@Payload NotificationPayload notificationPayload) {
        log.info("Received notification: {}", notificationPayload);
        notificationTypeHandler.send(
                notificationPayload.getNotificationType(), notificationPayload.getMessage()
        );
    }

}
