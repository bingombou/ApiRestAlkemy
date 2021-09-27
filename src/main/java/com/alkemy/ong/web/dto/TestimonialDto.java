package com.alkemy.ong.web.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestimonialDto {
    private Long id;
    private String name;
    private String image;
    private String content;
    private int deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
