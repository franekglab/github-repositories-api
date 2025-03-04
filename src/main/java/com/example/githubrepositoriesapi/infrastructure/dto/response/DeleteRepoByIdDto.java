package com.example.githubrepositoriesapi.infrastructure.dto.response;

import org.springframework.http.HttpStatus;

public record DeleteRepoByIdDto(String message, HttpStatus httpStatus) {
}
