package com.post.domain.post.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.post.domain.post.dto.request.PostCreateRequest;
import com.post.domain.post.dto.request.PostUpdateRequest;
import com.post.domain.post.dto.response.PostListResponse;
import com.post.domain.post.dto.response.PostListResultResponse;
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

	//게시글 수정
	@Transactional
	public PostResponse update(PostUpdateRequest request, Long postId) {

		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));

		post.update(request);

		return PostResponse.from(post);
	}

	//게시글 삭제
	@Transactional
	public void delete(Long postId) {
		postRepository.deleteById(postId);
	}

	//게시글 전체 조회 - 정렬 포함
	public PostListResultResponse getAllExistSort() {
		List<Post> allPosts = postRepository.findAllByOrderByCreatedAtDesc();

		List<PostListResponse> data = allPosts.stream()
			.map(PostListResponse::of)
			.toList();

		return new PostListResultResponse(
			data,
			allPosts.size()
		);
	}

	//게시글 전체 조회 - 페이징까지 포함
	public PostListResultResponse getAllExistPaging(Pageable pageable) {
		Pageable sortedPageable = PageRequest.of(
			pageable.getPageNumber(),
			pageable.getPageSize(),
			Sort.by(Sort.Direction.DESC, "createdAt")
		);
		Page<Post> allPostsExistPaging = postRepository.findAll(sortedPageable);

		List<PostListResponse> data = allPostsExistPaging.stream()
			.map(PostListResponse::of)
			.toList();

		return new PostListResultResponse(
			data,
			allPostsExistPaging.getTotalElements()
		);
	}

	//게시글 단건 조회
	public PostResponse getPost(Long postId) {
		Post post = postRepository.findById(postId)
			.orElseThrow(() -> new BusinessException(ErrorCode.POST_NOT_FOUND));
		return PostResponse.from(post);
	}

}
