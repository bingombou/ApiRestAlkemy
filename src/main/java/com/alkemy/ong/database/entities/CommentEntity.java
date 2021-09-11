package com.alkemy.ong.database.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class CommentEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private int idComment;

    @Column(name = "id_news", nullable = false)
    private int idNews;

    @Column(name = "id_user", nullable = false)
    private Long idUser;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
