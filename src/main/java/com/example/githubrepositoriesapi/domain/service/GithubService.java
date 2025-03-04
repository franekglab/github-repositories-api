package com.example.githubrepositoriesapi.domain.service;

import com.example.githubrepositoriesapi.domain.model.branch.Branch;
import com.example.githubrepositoriesapi.domain.model.entity.GitRepo;
import com.example.githubrepositoriesapi.domain.model.githubrepos.Repository;
import com.example.githubrepositoriesapi.domain.proxy.GithubApiClient;
import com.example.githubrepositoriesapi.infrastructure.dto.response.GetBranchesResponseDto;
import com.example.githubrepositoriesapi.infrastructure.dto.response.GetMergedDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final GithubApiClient githubApiClient;
    private final RepoAdder repoAdderService;

    public List<GetMergedDataResponseDto> getMergedData(String userName) {
        List<Repository> repositories = githubApiClient.getRepositoriesByUserName(userName);
        List<GetMergedDataResponseDto> mergedDataList = new ArrayList<>();

        for (Repository repository : repositories) {
            if (!repository.fork()) {
                List<GetBranchesResponseDto> branches = fetchBranches(repository.owner().login(), repository.name());
                mergedDataList.add(new GetMergedDataResponseDto(repository.name(), false, repository.owner().login(), branches));
            }
        }
        return mergedDataList;
    }

    public void saveRepositoriesToDatabase(List<GetMergedDataResponseDto> mergedDataList) {
        for(GetMergedDataResponseDto mergedData : mergedDataList) {
            repoAdderService.addRepoToDatabase(new GitRepo(mergedData.name(), mergedData.owner()));
        }
    }

    private List<GetBranchesResponseDto> fetchBranches(String userName, String repositoryName) {
        List<Branch> branches = githubApiClient.getAllRepoBranches(userName, repositoryName);
        List<GetBranchesResponseDto> branchesResponse = new ArrayList<>();

        for (Branch branch : branches) {
            final String sha;
            if (branch.commit() != null) {
                sha = branch.commit().sha();
            } else {
                sha = null;
            }
            branchesResponse.add(new GetBranchesResponseDto(branch.name(), sha));
        }
        return branchesResponse;
    }
}
