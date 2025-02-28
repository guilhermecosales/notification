package com.github.notification.adapter.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("rabbitQueueProperties")
@ConfigurationProperties(prefix = "spring.rabbitmq")
public class RabbitQueueProperties {

    private Queue queue;

    private Exchange exchange;

    private Routing routing;

    public RabbitQueueProperties() {
    }

    public RabbitQueueProperties(Queue queue, Exchange exchange, Routing routing) {
        this.queue = queue;
        this.exchange = exchange;
        this.routing = routing;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Exchange getExchange() {
        return exchange;
    }

    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

    public Routing getRouting() {
        return routing;
    }

    public void setRouting(Routing routing) {
        this.routing = routing;
    }

    public static class Queue {

        private String main;
        private String dlq;

        public Queue() {
        }

        public Queue(String main, String dlq) {
            this.main = main;
            this.dlq = dlq;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDlq() {
            return dlq;
        }

        public void setDlq(String dlq) {
            this.dlq = dlq;
        }
    }

    public static class Exchange {

        private String main;
        private String dlx;

        public Exchange() {
        }

        public Exchange(String main, String dlx) {
            this.main = main;
            this.dlx = dlx;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDlx() {
            return dlx;
        }

        public void setDlx(String dlx) {
            this.dlx = dlx;
        }
    }

    public static class Routing {

        private String key;
        private String dlqKey;

        public Routing() {
        }

        public Routing(String key, String dlqKey) {
            this.key = key;
            this.dlqKey = dlqKey;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getDlqKey() {
            return dlqKey;
        }

        public void setDlqKey(String dlqKey) {
            this.dlqKey = dlqKey;
        }
    }
}