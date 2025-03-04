package com.example.githubrepositoriesapi.infrastructure.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record UpdateRepoRequestDto(
        @NotEmpty(message = "ownerName can not be empty")
        @NotNull(message = "ownerName can not be null")
        String owner,
        @NotEmpty(message = "repoName can not be empty")
        @NotNull(message = "repoName can not be null")
        String name
) {
}
