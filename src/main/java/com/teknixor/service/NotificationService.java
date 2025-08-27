package com.teknixor.service;

import io.smallrye.mutiny.Uni;

public interface NotificationService {
    Uni<String> send(String message);
}
