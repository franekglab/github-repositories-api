package com.example.githubrepositoriesapi.domain.service;


import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.domain.repository.GithubReposRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Log4j2
public class RepoRetriever {

    private final GithubReposRepository githubReposRepository;

    public List<GitRepo> getAllReposFromDatabase(Pageable pageable) {
        log.info("Retrieving all repos from database");
        return githubReposRepository.findAll(pageable);
    }
}
