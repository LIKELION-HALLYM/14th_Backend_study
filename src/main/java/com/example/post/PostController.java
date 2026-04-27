package com.example.post;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostResponse create(@RequestBody @Valid PostRequest postRequest) {
        return postService.create(postRequest);

    }
    //전체조회
    @GetMapping
    public List<PostAllResponse> findAll() {
        return postService.findAll();
    }
    //단일조회
    @GetMapping("/{postId}")
    public PostResponse findById(@PathVariable Long postId) {
        return postService.findById(postId);
    }

    //수정
    @PatchMapping("/{postId}")
    public PostResponse update(@PathVariable Long postId, @RequestBody @Valid PostUpdate update) {
        return postService.update(postId, update);
    }

    //삭제
    @DeleteMapping("/{postId}")
    public ResponseEntity<String> delete(@PathVariable Long postId) {
        postService.delete(postId);
        return ResponseEntity.ok("삭제가 완료되었습니다.");
    }

}
