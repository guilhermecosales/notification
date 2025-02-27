package com.github.notification.adapter.inbound.controller;

import com.github.notification.adapter.dto.NotificationResponse;
import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class NotificationController {

    private final NotificationService notificationService;

    private final ModelMapper modelMapper;

    public NotificationController(NotificationService notificationService, ModelMapper modelMapper) {
        this.notificationService = notificationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getNotifications() {
        List<NotificationDomain> notifications = notificationService.getNotifications();

        List<NotificationResponse> notificationResponses = notifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationResponse.class))
                .toList();

        return ResponseEntity.ok(notificationResponses);
    }

}
