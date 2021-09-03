package com.alkemy.ong.database.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(length = 50)
    private String facebookUrl;

    @Column(length = 50)
    private String instagramUrl;

    @Column(length = 50)
    private String linkedinUrl;

    @Column(nullable = false)
    private String image;

    @Column(length = 50)
    private String description;

    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;
}
