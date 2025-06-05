package com.github.notification.adapter.inbound.consumer;

import com.github.notification.application.message.queue.NotificationPayload;
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

    @RabbitListener(queues = "${spring.rabbitmq.queue.main}")
    public void consume(@Payload NotificationPayload notificationPayload) {
        try {
            log.info("Received notification: {}", notificationPayload);
            notificationTypeHandler.send(
                    notificationPayload.getNotificationType(),
                    notificationPayload.getMessage()
            );
        } catch (Exception e) {
            log.error("Error processing notification: {}", notificationPayload, e);
        }
    }

}
