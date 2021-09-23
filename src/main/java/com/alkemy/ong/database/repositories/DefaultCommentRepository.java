package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.CommentEntity;
import com.alkemy.ong.database.jparepositories.CommentJpaRepository;
import com.alkemy.ong.domain.comments.CommentModel;
import com.alkemy.ong.domain.comments.CommentsRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;


@Repository
public class DefaultCommentRepository implements CommentsRepository {

    private CommentJpaRepository jpaRepository;

    public DefaultCommentRepository(CommentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public CommentModel createComment(CommentModel comment) {
        return toModel(jpaRepository.save(createModelEntity(comment)));
    }

    @Override
    public void deleteComment(CommentModel comment) {
        jpaRepository.delete(toEntity(comment));
    }

    @Override
    public Optional<CommentModel> findById(CommentModel comment) {
        return jpaRepository.findById(comment.getId()).map(this::toModel);
    }

    private CommentEntity createModelEntity(CommentModel commentModel) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setBody(commentModel.getBody());
        commentEntity.setIdNews(commentModel.getIdNews());
        commentEntity.setIdUser(commentModel.getIdUser());
        commentEntity.setCreatedAt(LocalDateTime.now());
        commentEntity.setUpdatedAt(LocalDateTime.now());
        return commentEntity;
    }

    private CommentEntity toEntity(CommentModel commentModel) {
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setId(commentModel.getId());
        commentEntity.setBody(commentModel.getBody());
        commentEntity.setIdNews(commentModel.getIdNews());
        commentEntity.setIdUser(commentModel.getIdUser());
        commentEntity.setCreatedAt(LocalDateTime.now());
        commentEntity.setUpdatedAt(LocalDateTime.now());
        return commentEntity;
    }

    private CommentModel toModel(CommentEntity commentEntity) {
        CommentModel comment = new CommentModel();
        comment.setBody(commentEntity.getBody());
        comment.setIdNews(commentEntity.getIdNews());
        comment.setIdUser(commentEntity.getIdUser());
        comment.setId(commentEntity.getId());
        comment.setCreatedAt(commentEntity.getCreatedAt());
        comment.setUpdatedAt(commentEntity.getUpdatedAt());
        return comment;
    }
}
