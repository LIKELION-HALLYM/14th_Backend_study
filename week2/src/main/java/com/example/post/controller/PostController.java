package com.example.post.controller;

import com.example.post.dto.PostListResponseDto;
import com.example.post.dto.PostRequestDto;
import com.example.post.dto.PostResponseDto;
import com.example.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.post.dto.SuccessResponse;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<SuccessResponse<PostResponseDto>> createPost(
            @Valid @RequestBody PostRequestDto requestDto) {
        PostResponseDto response = postService.createPost(requestDto);
        return ResponseEntity.ok(SuccessResponse.of("게시글이 등록되었습니다.", response));
    }

    @GetMapping
    public ResponseEntity<SuccessResponse<List<PostListResponseDto>>> getAllPosts() {
        return ResponseEntity.ok(SuccessResponse.of("게시글 목록 조회 성공", postService.getAllPosts()));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<SuccessResponse<PostResponseDto>> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(SuccessResponse.of("게시글 조회 성공", postService.getPost(postId)));
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<SuccessResponse<PostResponseDto>> updatePost(
            @PathVariable Long postId,
            @Valid @RequestBody PostRequestDto requestDto) {
        return ResponseEntity.ok(SuccessResponse.of("게시글이 수정되었습니다.", postService.updatePost(postId, requestDto)));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<SuccessResponse<Void>> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok(SuccessResponse.of("게시글이 삭제되었습니다."));
    }
}