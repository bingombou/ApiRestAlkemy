package com.alkemy.ong.database.entities;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "categories")
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CategoriesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name field is required")
    @Column(name = "name", length = 45)
    private String name;

    @NotEmpty(message = "description field is required")
    @Column(name = "description")
    private String description;

    @NotEmpty(message = "image field is required")
    @Column(name = "image", length = 45)
    private String image;

    @Column(nullable = false, name="created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name="updated_at")
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean deleted;
}
