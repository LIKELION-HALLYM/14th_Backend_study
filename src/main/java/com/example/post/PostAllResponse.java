package com.example.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostAllResponse {


    private Long id;
    private String title;
    private String author;
    private LocalDateTime createdAt;

    public PostAllResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.createdAt = post.getCreatedAt();
    }
}
