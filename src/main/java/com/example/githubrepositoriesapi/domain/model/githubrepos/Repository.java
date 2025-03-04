package com.example.githubrepositoriesapi.domain.model.githubrepos;

public record Repository(String name, Owner owner, boolean fork) {
}