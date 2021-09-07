package com.alkemy.ong.domain.slide;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class SlideModel {
    private int id;
    private int idCategory;
    private int order;
    private String text;
    private String imageUrl;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}