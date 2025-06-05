package com.github.notification.application.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueSetupConfiguration {

    private final RabbitQueueProperties properties;

    public RabbitQueueSetupConfiguration(RabbitQueueProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Queue notificationsQueue() {
        return QueueBuilder.durable(properties.getQueue().getMain())
                .deadLetterExchange(properties.getExchange().getDlx())
                .deadLetterRoutingKey(properties.getRouting().getDlqKey())
                .build();
    }

    @Bean
    public Queue deadLetterQueue() {
        return QueueBuilder.durable(properties.getQueue().getDlq()).build();
    }

    @Bean
    public DirectExchange notificationsExchange() {
        return new DirectExchange(properties.getQueue().getMain());
    }

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange(properties.getExchange().getDlx());
    }

    @Bean
    public Binding bindingNotificationsQueue(Queue notificationsQueue, DirectExchange notificationsExchange) {
        return BindingBuilder.bind(notificationsQueue)
                .to(notificationsExchange)
                .with(properties.getRouting().getKey());
    }

    @Bean
    public Binding bindingDeadLetterQueue(Queue deadLetterQueue, DirectExchange deadLetterExchange) {
        return BindingBuilder.bind(deadLetterQueue)
                .to(deadLetterExchange)
                .with(properties.getRouting().getDlqKey());
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setDefaultRequeueRejected(false);
        factory.setMessageConverter(jsonMessageConverter());
        return factory;
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}