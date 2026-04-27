package com.example.post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AllExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle400Exception() {
        return ResponseEntity
                .status(400)
                .body("잘못된 요청입니다.");
    }

    //서버 오류
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle500Exception() {
        return ResponseEntity
                .status(500)
                .body("서버 오류가 발생했습니다.");
    }
}
