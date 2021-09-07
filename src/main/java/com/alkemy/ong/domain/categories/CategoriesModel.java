package com.alkemy.ong.domain.categories;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CategoriesModel {

    private Long id;
    private String name;
    private String description;
    private String image;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}