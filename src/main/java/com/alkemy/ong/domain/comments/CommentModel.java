package com.alkemy.ong.domain.comments;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentModel {
    private int id;
    private long idUser;
    private int idNews;
    private String body;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
