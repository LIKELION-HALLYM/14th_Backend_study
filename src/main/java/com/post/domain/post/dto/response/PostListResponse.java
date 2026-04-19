package com.post.domain.post.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.post.domain.post.entity.Post;


public record PostListResponse (
	Long id,
	String title,
	String author,
	@JsonProperty("created_at")
	LocalDate createdAt
) {
	public static PostListResponse of(Post post) {
		return new PostListResponse(
			post.getPostId(),
			post.getTitle(),
			post.getAuthor(),
			post.getCreatedAt().toLocalDate()
		);
	}
}
