package com.example.githubrepositoriesapi.domain.service;

import com.example.githubrepositoriesapi.domain.model.branch.Branch;
import com.example.githubrepositoriesapi.domain.model.branch.Commit;
import com.example.githubrepositoriesapi.domain.model.repository.Repository;
import com.example.githubrepositoriesapi.domain.proxy.GithubApiClient;
import com.example.githubrepositoriesapi.infrastructure.dto.GetBranchesResponseDto;
import com.example.githubrepositoriesapi.infrastructure.dto.GetMergedDataResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GithubService {

    private final GithubApiClient githubApiClient;

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
