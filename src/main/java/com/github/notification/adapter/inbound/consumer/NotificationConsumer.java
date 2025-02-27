package com.github.notification.adapter.inbound.consumer;

import com.github.notification.adapter.dto.NotificationPayload;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {

    private final ModelMapper modelMapper;

    public NotificationConsumer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @RabbitListener(queues = "notification-queue")
    public void consume(@Payload NotificationPayload notificationPayload) {
        System.out.println("Received message: " + notificationPayload);
    }

}
