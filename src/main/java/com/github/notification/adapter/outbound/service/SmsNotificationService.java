package com.github.notification.adapter.outbound.service;


import com.github.notification.core.port.NotificationSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationSenderService {

    private final Logger log = LoggerFactory.getLogger(SmsNotificationService.class);

    @Override
    public void send(String message) {
        log.info("Sending SMS: {}", message);
    }

}
