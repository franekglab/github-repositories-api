package com.example.githubrepositoriesapi.infrastructure.dto.response;

import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;

import java.util.List;

public record GetAllReposFromDatabaseDto(List<GitRepo> repos) {
}
