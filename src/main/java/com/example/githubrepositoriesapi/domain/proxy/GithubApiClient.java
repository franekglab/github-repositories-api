package com.example.githubrepositoriesapi.domain.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github-api")
public interface GithubApiClient {

    @GetMapping("/users/{username}/repos")
    List<RepositoryDto> getUserRepositories(@PathVariable String username);
}
