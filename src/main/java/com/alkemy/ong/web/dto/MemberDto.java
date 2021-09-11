package com.alkemy.ong.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class MemberDto {


    private Long id;

    @NotEmpty(message = "Name field is required")
    @Column(nullable = false, length = 25)
    private String name;

    private String facebookUrl;
    private String instagramUrl;
    private String linkedinUrl;
    private String image;
    private String description;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
