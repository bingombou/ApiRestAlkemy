package com.alkemy.ong.database.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(length = 50, name = "facebook_url")
    private String facebookUrl;

    @Column(length = 50, name="instagram_url")
    private String instagramUrl;

    @Column(length = 50, name = "linkedin_url")
    private String linkedinUrl;

    @Column(nullable = false)
    private String image;

    @Column(length = 50)
    private String description;

    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;

    @Column(nullable = false, name="created_at")
    private LocalDateTime createdAt;

    @Column(nullable = false, name = "updated_at")
    private LocalDateTime updatedAt;
}
