package com.alkemy.ong.database.entities;

import lombok.Data;
import org.hibernate.annotations.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="news")
public class NewsEntity{

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotEmpty(message = "Name field is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotEmpty(message = "content field is required")
    @Column(name = "content",length = 250, nullable = false)
    private String content;

    @NotEmpty(message = "Image field is required")
    @Column(name = "image", nullable = false)
    private String image;

    @Generated( value = GenerationTime.ALWAYS)
    @Column(name = "created_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Generated( value = GenerationTime.ALWAYS)
    @Column(name = "updated_at", nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;
}
