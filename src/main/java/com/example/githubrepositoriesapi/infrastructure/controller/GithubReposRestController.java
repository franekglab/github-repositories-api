package com.example.githubrepositoriesapi.infrastructure.controller;

import com.example.githubrepositoriesapi.domain.service.GithubService;
import com.example.githubrepositoriesapi.infrastructure.dto.GetMergedDataResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping("/repos")
public class GithubReposRestController {

    private final GithubService githubService;

    @GetMapping(value = "/{userName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GetMergedDataResponseDto>> getAllMergedData(@PathVariable String userName) {
        List<GetMergedDataResponseDto> mergedAllDataList = githubService.getMergedData(userName);
        return ResponseEntity.ok(mergedAllDataList);

    }
}
