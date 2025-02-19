package com.example.githubrepositoriesapi.infrastructure.error;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
