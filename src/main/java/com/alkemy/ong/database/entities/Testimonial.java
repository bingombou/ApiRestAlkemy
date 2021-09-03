package com.alkemy.ong.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "testimonials")
public class Testimonial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column (name = "name", length = 30, nullable = false)
    private String name;

    @Column (name = "image", length = 100)
    private String image;

    @Column (name = "content", length = 200)
    private String content;

    @Column (name = "deleted", length = 1)
    private int deleted;

    @Column (name = "createdAt", length = 30)
    private LocalDateTime createdAt;

    @Column (name = "updatedAt", length = 30)
    private LocalDateTime updatedAt;

}
