package com.example.githubrepositoriesapi.domain.model.repository;

public record Repository(String name, Owner owner, boolean fork) {
}