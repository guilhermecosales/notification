package com.github.notification.adapter.outbound.sender;

import com.github.notification.core.port.NotificationSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements NotificationSenderService {

    private final Logger log = LoggerFactory.getLogger(PushNotificationService.class);

    @Override
    public void send(String message) {
        log.info("Sending Push: {}", message);
    }

}
