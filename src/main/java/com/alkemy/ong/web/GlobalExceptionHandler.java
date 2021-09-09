package com.alkemy.ong.web;

import com.alkemy.ong.domain.slides.SlideDomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {SlideDomainException.class})
    public ResponseEntity<?>handleSlideException(Exception e){
        return ResponseEntity.notFound().build();
    }
}
