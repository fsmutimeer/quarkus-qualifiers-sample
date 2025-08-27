package com.teknixor.service;

import com.teknixor.qualifier.EmailQualifier;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@EmailQualifier
public class EmailNotificationService implements NotificationService {

    @Override
    public Uni<String> send(String message) {
        return Uni.createFrom().item(() -> "Email sent with message: " + message);
    }

}
