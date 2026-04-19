package com.post.domain.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.post.domain.post.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findByTitle(String title);

	List<Post> findAllByOrderByCreatedAtDesc();

	//페이징 적용
	Page<Post> findAll(Pageable pageable);

}
