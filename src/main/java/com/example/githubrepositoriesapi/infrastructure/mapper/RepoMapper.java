package com.example.githubrepositoriesapi.infrastructure.mapper;

import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.infrastructure.dto.request.AddRepoManuallyRequestDto;
import com.example.githubrepositoriesapi.infrastructure.dto.request.UpdateRepoRequestDto;
import com.example.githubrepositoriesapi.infrastructure.dto.response.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public class RepoMapper {

    public static GetAllReposFromDatabaseDto mapFromRepoToGetAllReposFromDatabaseDto(List<GitRepo> repos) {
        return new GetAllReposFromDatabaseDto(repos);
    }

    public static DeleteRepoByIdDto mapFromRepoToDeleteRepoById(Long id) {
        return new DeleteRepoByIdDto("Song with id: " + id + " has been deleted", HttpStatus.OK);
    }

    public static GitRepo mapFromAddRepoManuallyRequestDtoToGitRepo(AddRepoManuallyRequestDto dto) {
        return new GitRepo(dto.owner(), dto.name());
    }

    public static RepoDto mapFromRepoToRepoDto(GitRepo repo) {
        return new RepoDto(repo.getOwner(), repo.getName());
    }

    public static AddRepoManuallyResponseDto mapFromRepoToAddRepoManuallyResponseDto(GitRepo repo) {
        RepoDto repoDto = mapFromRepoToRepoDto(repo);
        return new AddRepoManuallyResponseDto(repoDto);
    }

    public static UpdateRepoResponseDto mapFromRepoToUpdateRepoResponseDto(GitRepo newRepo) {
        return new UpdateRepoResponseDto(newRepo.getOwner(), newRepo.getName());
    }

    public static GitRepo mapFromUpdateRepoRequestDtoToRepo(UpdateRepoRequestDto dto) {
        return new GitRepo(dto.owner(), dto.name());
    }
}
