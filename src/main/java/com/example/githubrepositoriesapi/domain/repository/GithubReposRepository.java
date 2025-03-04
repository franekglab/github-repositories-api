package com.example.githubrepositoriesapi.domain.repository;

import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface GithubReposRepository extends Repository<GitRepo, Long> {

    GitRepo save(GitRepo gitRepo);

    @Query("SELECT repo FROM GitRepo repo")
    List<GitRepo> findAll(Pageable pageable);

    @Modifying
    @Query("DELETE FROM GitRepo repo WHERE repo.id = :id")
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE GitRepo repo SET repo.owner = :#{#newRepo.owner}, repo.name = :#{#newRepo.name} WHERE repo.id = :id")
    void updateById(Long id, GitRepo newRepo);
}
