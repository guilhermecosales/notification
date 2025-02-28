package com.github.notification.adapter.inbound.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class DeadLetterConsumer {

    private final Logger log = LoggerFactory.getLogger(DeadLetterConsumer.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue.dlq}")
    public void consume(@Payload String payload) {
        log.warn("Dead Letter Queue - Processing failed notification: {}", payload);
    }

}
