package com.example.githubrepositoriesapi.domain.proxy;

import com.example.githubrepositoriesapi.config.Config;
import com.example.githubrepositoriesapi.domain.model.branch.Branch;
import com.example.githubrepositoriesapi.domain.model.githubrepos.Repository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "github-api", configuration = Config.class)
public interface GithubApiClient {

    @GetMapping("/users/{userName}/repos")
    List<Repository> getRepositoriesByUserName(@PathVariable String userName);

    @GetMapping("/repos/{owner}/{repositoryName}/branches")
    List<Branch> getAllRepoBranches(@PathVariable String owner, @PathVariable String repositoryName);


}

