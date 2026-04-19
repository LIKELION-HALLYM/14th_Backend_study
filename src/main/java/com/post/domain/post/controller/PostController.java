package com.post.domain.post.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.domain.post.dto.request.PostCreateRequest;
import com.post.domain.post.dto.request.PostUpdateRequest;
import com.post.domain.post.dto.response.PostResponse;
import com.post.domain.post.service.PostService;
import com.post.global.common.dto.SuccessResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/posts")
public class PostController {

	private final PostService postService;

	@PostMapping
	public SuccessResponse<PostResponse> createPost(
		@Valid @RequestBody PostCreateRequest postCreateRequest
	){
		return SuccessResponse.created(postService.create(postCreateRequest));
	}

	@PatchMapping("/{id}")
	public SuccessResponse<PostResponse> updatePost(
		@Valid @RequestBody PostUpdateRequest postUpdateRequest,
		@PathVariable Long id
	) {
		return SuccessResponse.ok(postService.update(postUpdateRequest, id));
	}

	@DeleteMapping("/{id}")
	public SuccessResponse<?> deletePost(
		@PathVariable Long id
	) {
		postService.delete(id);
		return SuccessResponse.noContent();
	}


}
