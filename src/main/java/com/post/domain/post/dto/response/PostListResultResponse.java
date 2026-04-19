package com.post.domain.post.dto.response;

import java.util.List;

public record PostListResultResponse(
	List<PostListResponse> data,
	long totalCount
) {
}
