package com.post.domain.post.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.post.domain.post.entity.Post;

public record PostResponse(
	Long id,
	String title,
	String content,
	String author,
	@JsonProperty("created_at")
	LocalDateTime createdAt,
	@JsonProperty("updated_at")
	LocalDateTime updatedAt
) {
	public static PostResponse from(Post post) {
		return new PostResponse(
			post.getPostId(),
			post.getTitle(),
			post.getContent(),
			post.getAuthor(),
			post.getCreatedAt(),
			post.getUpdatedAt()
		);
	}
}
