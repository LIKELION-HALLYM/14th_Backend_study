package com.post.domain.post.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.post.domain.post.dto.request.PostCreateRequest;
import com.post.domain.post.dto.response.PostResponse;
import com.post.domain.post.entity.Post;
import com.post.domain.post.repository.PostRepository;
import com.post.global.exception.BusinessException;
import com.post.global.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

	private final PostRepository postRepository;

	//게시글 생성
	@Transactional
	public PostResponse create(PostCreateRequest request) {

		postRepository.findByTitle(request.title())
			.orElseThrow(() -> new BusinessException(ErrorCode.POST_ALREADY_EXISTS));

		Post post = Post.create(
			request.title(),
			request.content(),
			request.author()
		);

		postRepository.save(post);

		return PostResponse.from(post);
	}

}
