package com.teknixor.service;

import com.teknixor.qualifier.PushNotificationQualifier;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@PushNotificationQualifier
public class PushNotificationService implements NotificationService {
    @Override
    public Uni<String> send(String message) {
        return Uni.createFrom().item(() -> "Push Notification sent with message: " + message);
    }
}