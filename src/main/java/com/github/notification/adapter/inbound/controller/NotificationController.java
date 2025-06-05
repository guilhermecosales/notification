package com.github.notification.adapter.inbound.controller;

import com.github.notification.application.message.http.NotificationResponse;
import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.usecase.GetNotificationsUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    private final GetNotificationsUseCase getNotificationsUseCase;

    private final ModelMapper modelMapper;

    public NotificationController(GetNotificationsUseCase getNotificationsUseCase, ModelMapper modelMapper) {
        this.getNotificationsUseCase = getNotificationsUseCase;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getNotifications() {
        List<NotificationDomain> notifications = getNotificationsUseCase.execute();

        List<NotificationResponse> notificationResponses = notifications.stream()
                .map(notification -> modelMapper.map(notification, NotificationResponse.class))
                .toList();

        return ResponseEntity.ok(notificationResponses);
    }

}
