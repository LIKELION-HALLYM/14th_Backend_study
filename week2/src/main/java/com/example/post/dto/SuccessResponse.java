package com.example.post.dto;

import lombok.Getter;

@Getter
public class SuccessResponse<T> {

    private final String message;
    private final T data;

    public SuccessResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }

    public static <T> SuccessResponse<T> of(String message, T data) {
        return new SuccessResponse<>(message, data);
    }

    public static SuccessResponse<Void> of(String message) {
        return new SuccessResponse<>(message, null);
    }
}