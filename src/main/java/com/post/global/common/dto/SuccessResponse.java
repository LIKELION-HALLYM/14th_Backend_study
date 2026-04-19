package com.post.global.common.dto;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SuccessResponse<T> {

	private final int status;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private final T data;

	private final String message;

	@Builder(access = AccessLevel.PRIVATE)
	private SuccessResponse(int status, T data, String message) {
		this.status = status;
		this.data = data;
		this.message = message;
	}

	// 200 OK (GET 조회 → 200)
	public static <T> SuccessResponse<T> ok(T data) {
		return SuccessResponse.<T>builder()
			.status(HttpStatus.OK.value())
			.message("요청 성공")
			.data(data)
			.build();
	}

	public static <T> SuccessResponse<T> ok(T data, String message) {
		return SuccessResponse.<T>builder()
			.status(HttpStatus.OK.value())
			.message(message)
			.data(data)
			.build();
	}

	// 201 Created (POST 생성 → 201)
	public static <T> SuccessResponse<T> created(T data) {
		return SuccessResponse.<T>builder()
			.status(HttpStatus.CREATED.value())
			.message("생성 완료")
			.data(data)
			.build();
	}

	public static <T> SuccessResponse<T> created(T data, String message) {
		return SuccessResponse.<T>builder()
			.status(HttpStatus.CREATED.value())
			.message(message)
			.data(data)
			.build();
	}

	// 204 No Content (DELETE 삭제 → 204)
	public static SuccessResponse<Void> noContent() {
		return SuccessResponse.<Void>builder()
			.status(HttpStatus.NO_CONTENT.value())
			.message("처리 완료")
			.build();
	}
}
