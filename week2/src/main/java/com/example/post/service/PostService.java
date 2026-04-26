package com.example.post.service;

import com.example.post.domain.Post;
import com.example.post.dto.PostListResponseDto;
import com.example.post.dto.PostRequestDto;
import com.example.post.dto.PostResponseDto;
import com.example.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor()
        );
        Post saved = postRepository.save(post);
        return new PostResponseDto(saved);
    }

    // 전체 조회
    public List<PostListResponseDto> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 상세 조회
    public PostResponseDto getPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return new PostResponseDto(post);
    }

    // 수정
    public PostResponseDto updatePost(Long postId, PostRequestDto requestDto) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        post.update(requestDto.getTitle(), requestDto.getContent());
        return new PostResponseDto(post);
    }

    // 삭제
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        postRepository.delete(post);
    }
}