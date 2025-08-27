package com.teknixor.service;

import com.teknixor.qualifier.GoogleAlertsQualifier;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@GoogleAlertsQualifier
public class GoogleAlertsNotificationService implements NotificationService {

    @Override
    public Uni<String> send(String message) {
        return Uni.createFrom().item(() -> "Google alerts Notification sent with message: " + message);
    }

}
