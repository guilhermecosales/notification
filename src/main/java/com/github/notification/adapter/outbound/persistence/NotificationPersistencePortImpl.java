package com.github.notification.adapter.outbound.persistence;


import com.github.notification.adapter.outbound.persistence.entity.NotificationEntity;
import com.github.notification.adapter.outbound.persistence.repository.NotificationRepository;
import com.github.notification.core.domain.NotificationDomain;
import com.github.notification.core.port.NotificationPersistencePort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NotificationPersistencePortImpl implements NotificationPersistencePort {

    private final NotificationRepository notificationRepository;

    private final ModelMapper modelMapper;

    public NotificationPersistencePortImpl(NotificationRepository notificationRepository, ModelMapper modelMapper) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public NotificationDomain save(NotificationDomain notification) {
        final NotificationEntity newNotification = modelMapper.map(notification, NotificationEntity.class);

        NotificationEntity storedNotification = notificationRepository.save(newNotification);

        return modelMapper.map(storedNotification, NotificationDomain.class);
    }

}
