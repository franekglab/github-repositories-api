package com.example.githubrepositoriesapi.domain.service;
import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.domain.repository.GithubReposRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class RepoUpdater {

    private final GithubReposRepository githubReposRepository;

    public void updateRepoById(Long id, GitRepo newRepo) {
        log.info("Repo with id " + id + " has been updated");
        githubReposRepository.updateById(id, newRepo);
    }
}
