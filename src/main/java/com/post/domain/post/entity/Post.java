package com.post.domain.post.entity;

import java.time.LocalDateTime;

import com.post.domain.post.dto.request.PostUpdateRequest;
import com.post.global.domain.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="posts")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Post extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "post_id")
	private Long postId;

	@Column(nullable = false, length = 100)
	private String title;

	@Lob
	@Column(nullable = false)
	private String content;

	@Column(nullable = false)
	private String author;

	public static Post create(String title, String content, String author) {
		return Post.builder()
			.title(title)
			.content(content)
			.author(author)
			.build();
	}

	//업데이트 로직
	public void update(PostUpdateRequest updateRequest) {
		if (title != null) this.title = updateRequest.title();
		if (content != null) this.content = updateRequest.content();
	}

}
