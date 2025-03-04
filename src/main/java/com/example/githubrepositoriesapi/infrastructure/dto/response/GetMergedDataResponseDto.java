package com.example.githubrepositoriesapi.infrastructure.dto.response;

import java.util.List;

public record GetMergedDataResponseDto(String name, boolean fork, String owner, List<GetBranchesResponseDto> branches) {
}
