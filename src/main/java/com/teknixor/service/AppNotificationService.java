package com.teknixor.service;

import com.teknixor.qualifier.AppNotificationQualifier;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AppNotificationQualifier
public class AppNotificationService implements NotificationService {

    @Override
    public Uni<String> send(String message) {
        System.out.println("Simulating a long-running operation...");
        return Uni.createFrom().item(() -> "App Notification sent with message: " + message);
    }

}
