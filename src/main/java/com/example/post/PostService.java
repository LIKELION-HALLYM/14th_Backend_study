package com.example.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public PostResponse  create(PostRequest request) {

        Post post = new Post(
                request.getTitle(),
                request.getContent(),
                request.getAuthor()
        );

        Post saved = postRepository.save(post);

        return new PostResponse(saved);
    }
    //전체조회
    public List<PostAllResponse> findAll() {
        List<Post> posts = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostAllResponse> result = new ArrayList<>();

        for(Post post : posts) {
            result.add(new PostAllResponse(post));

        }
        return result;
    }

    //단일조회
    public PostResponse findById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));

        return new PostResponse(post);
    }
    //수정
    public PostResponse update(Long id, PostUpdate update) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시글 입니다."));
        post.update(update.getTitle(), update.getContent());
        Post saved = postRepository.save(post);

        return new PostResponse(saved);

    }
    //삭제
    public void delete(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 게시판입니다."));
        postRepository.delete(post);
    }
}
