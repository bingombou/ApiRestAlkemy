package com.alkemy.ong.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsDto{

    private Long id;

    @NotEmpty(message = "Name field is required")
    @Column(nullable = false, length = 25)
    private String name;
    @NotEmpty(message = "Image field is required")
    @Column(nullable = false)
    private String image;
    @NotEmpty(message = "Content field is required")
    @Column(nullable = false, length = 255)
    private String content;
    @Column(nullable = false)
    private boolean deleted;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public NewsDto(Long id, String name, String content, String image, LocalDateTime createdAt, LocalDateTime updatedAt) {
    }
}
