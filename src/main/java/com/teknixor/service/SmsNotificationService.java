package com.teknixor.service;

import com.teknixor.qualifier.SmsNotificationQualifier;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@SmsNotificationQualifier
public class SmsNotificationService implements NotificationService {

    @Override
    public Uni<String> send(String message) {
        return Uni.createFrom().item(() -> "SMS sent with message: " + message);
    }

}
