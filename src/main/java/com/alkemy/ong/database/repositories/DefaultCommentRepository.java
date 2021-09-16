package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.CommentEntity;
import com.alkemy.ong.database.jparepositories.CommentJpaRepository;
import com.alkemy.ong.domain.comments.CommentModel;
import com.alkemy.ong.domain.comments.CommentsRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class DefaultCommentRepository implements CommentsRepository {

    private CommentJpaRepository jpaRepository;

    public DefaultCommentRepository(CommentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CommentModel createComment(CommentModel commentModel) {
        return toModel(jpaRepository.save(toEntity(commentModel)));
    }

    private CommentEntity toEntity(CommentModel commentModel) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setBody(commentModel.getBody());
        commentEntity.setIdNews(commentModel.getIdNews());
        commentEntity.setIdUser(commentModel.getIdUser());
        commentEntity.setCreatedAt(LocalDateTime.now());
        commentEntity.setUpdatedAt(LocalDateTime.now());
        return commentEntity;
    }

    private CommentModel toModel(CommentEntity commentEntity) {
        CommentModel commentModel = new CommentModel();
        commentModel.setBody(commentEntity.getBody());
        commentModel.setIdNews(commentEntity.getIdNews());
        commentModel.setIdUser(commentEntity.getIdUser());
        commentModel.setId(commentEntity.getIdComment());
        commentModel.setCreatedAt(commentEntity.getCreatedAt());
        commentModel.setUpdatedAt(commentEntity.getUpdatedAt());

        return commentModel;
    }
}
