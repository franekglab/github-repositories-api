package com.example.githubrepositoriesapi.domain.service;

import com.example.githubrepositoriesapi.domain.repository.GithubReposRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class RepoDeleter {

    private final GithubReposRepository githubReposRepository;

    public void deleteRepoById(Long id) {
        log.info("Deleting repo with id: " + id);
        githubReposRepository.deleteById(id);
    }
}
