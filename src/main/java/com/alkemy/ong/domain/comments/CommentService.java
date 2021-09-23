package com.alkemy.ong.domain.comments;

public interface CommentService {

    public CommentModel createComment(CommentModel commentModel);

    public void deleteComment(CommentModel commentModel);
}
