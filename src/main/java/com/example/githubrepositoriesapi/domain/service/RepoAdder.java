package com.example.githubrepositoriesapi.domain.service;

import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.domain.repository.GithubReposRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
@Transactional
public class RepoAdder {

    private final GithubReposRepository githubReposRepository;

    public GitRepo addRepoToDatabase(GitRepo savedRepo) {
        log.info("Adding repositories to database");
        return githubReposRepository.save(savedRepo);
    }
}
