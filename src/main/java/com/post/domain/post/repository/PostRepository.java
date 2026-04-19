package com.post.domain.post.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.domain.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findByTitle(String title);
	Optional<Post> findByPostId(String postId);
}
