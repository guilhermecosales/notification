package com.github.notification.adapter.outbound.service;


import com.github.notification.core.port.NotificationSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationSenderService {

    private final Logger log = LoggerFactory.getLogger(EmailNotificationService.class);

    @Override
    public void send(String message) {
        log.info("Sending Email: {}", message);
    }

}
