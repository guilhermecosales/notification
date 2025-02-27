package com.github.notification.adapter.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitQueueSetupConfiguration {

    private final RabbitQueueProperties rabbitQueueProperties;

    public RabbitQueueSetupConfiguration(RabbitQueueProperties rabbitQueueProperties) {
        this.rabbitQueueProperties = rabbitQueueProperties;
    }

    @Bean
    public Queue queue() {
        return new Queue(rabbitQueueProperties.getQueueName(), false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(rabbitQueueProperties.getExchangeName());
    }

    @Bean
    public Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(rabbitQueueProperties.getRoutingKey());
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}