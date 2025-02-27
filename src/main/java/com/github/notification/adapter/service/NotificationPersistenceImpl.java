package com.github.notification.adapter.service;


import com.github.notification.adapter.outbound.persistence.entity.NotificationEntity;
import com.github.notification.adapter.outbound.persistence.repository.NotificationRepository;
import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationPersistenceImpl implements NotificationPersistence {

    private final NotificationRepository notificationRepository;

    private final ModelMapper modelMapper;

    public NotificationPersistenceImpl(NotificationRepository notificationRepository, ModelMapper modelMapper) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NotificationDomain save(NotificationDomain notification) {
        final NotificationEntity newNotification = modelMapper.map(notification, NotificationEntity.class);

        NotificationEntity storedNotification = notificationRepository.save(newNotification);

        return modelMapper.map(storedNotification, NotificationDomain.class);
    }

    @Override
    public List<NotificationDomain> findAll() {
        return notificationRepository.findAll().stream()
                .map(notificationEntity -> modelMapper.map(notificationEntity, NotificationDomain.class))
                .toList();
    }

}
