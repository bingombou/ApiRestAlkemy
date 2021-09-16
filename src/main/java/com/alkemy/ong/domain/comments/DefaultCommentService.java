package com.alkemy.ong.domain.comments;

import org.springframework.stereotype.Service;

@Service
public class DefaultCommentService implements CommentService {

    private CommentsRepository commentsRepository;

    public DefaultCommentService(CommentsRepository commentsRepository) {
        this.commentsRepository = commentsRepository;
    }

    @Override
    public CommentModel createComment(CommentModel commentModel) {

        return commentsRepository.createComment(commentModel);
    }
}
