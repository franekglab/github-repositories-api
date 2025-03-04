package com.example.githubrepositoriesapi.infrastructure.controller;

import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.domain.service.*;
import com.example.githubrepositoriesapi.infrastructure.dto.request.AddRepoManuallyRequestDto;
import com.example.githubrepositoriesapi.infrastructure.dto.request.UpdateRepoRequestDto;
import com.example.githubrepositoriesapi.infrastructure.dto.response.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.githubrepositoriesapi.infrastructure.mapper.RepoMapper.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/repos")
public class GithubReposRestController {

    private final GithubService githubService;
    private final RepoRetriever repoRetriever;
    private final RepoDeleter repoDeleter;
    private final RepoAdder repoAdder;
    private final RepoUpdater repoUpdater;

    //Get data from github api
    @GetMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetMergedDataResponseDto>> getAllMergedData(@PathVariable String userName) {
        List<GetMergedDataResponseDto> mergedAllDataList = githubService.getMergedData(userName);
        githubService.saveRepositoriesToDatabase(mergedAllDataList);
        return ResponseEntity.ok(mergedAllDataList);
    }

    //AllReposFromDatabase
    @GetMapping
    public ResponseEntity<GetAllReposFromDatabaseDto> getAllReposFromDatabase(Pageable pageable) {
        List<GitRepo> allRepoList = repoRetriever.getAllReposFromDatabase(pageable);
        GetAllReposFromDatabaseDto response = mapFromRepoToGetAllReposFromDatabaseDto(allRepoList);
        return ResponseEntity.ok(response);
    }

    //DeleteRepoFromDatabaseById
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteRepoByIdDto> deleteRepoById(@PathVariable Long id) {
        repoDeleter.deleteRepoById(id);
        DeleteRepoByIdDto response = mapFromRepoToDeleteRepoById(id);
        return ResponseEntity.ok(response);
    }

    //AddRepoManuallyToDataBase
    @PostMapping
    public ResponseEntity<AddRepoManuallyResponseDto> addRepoManually(@RequestBody @Valid AddRepoManuallyRequestDto request) {
        GitRepo repo =  mapFromAddRepoManuallyRequestDtoToGitRepo(request);
        GitRepo addedRepo = repoAdder.addRepoToDatabase(repo);
        AddRepoManuallyResponseDto response = mapFromRepoToAddRepoManuallyResponseDto(addedRepo);
        return ResponseEntity.ok(response);
    }

    //UpdateRepoById
    @PutMapping("/{id}")
    public ResponseEntity<UpdateRepoResponseDto> updateRepoById(@PathVariable Long id,
                                                                @RequestBody @Valid UpdateRepoRequestDto request) {
        GitRepo newRepo = mapFromUpdateRepoRequestDtoToRepo(request);
        repoUpdater.updateRepoById(id, newRepo);
        UpdateRepoResponseDto response = mapFromRepoToUpdateRepoResponseDto(newRepo);
        return ResponseEntity.ok(response);
    }

}
