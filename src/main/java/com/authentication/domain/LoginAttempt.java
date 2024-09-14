package com.authentication.domain;

import java.time.LocalDateTime;

    public record LoginAttempt(String name,
                               boolean success,
                               LocalDateTime createdAt) {

    }

