package com.example.githubrepositoriesapi.infrastructure.dto;

import com.example.githubrepositoriesapi.domain.model.branch.Branch;
import com.example.githubrepositoriesapi.domain.model.repository.Owner;

import java.util.List;

public record GetMergedDataResponseDto(String name, boolean fork, String owner, List<GetBranchesResponseDto> branches) {
}
