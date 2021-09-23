package com.alkemy.ong.domain.comments;

import java.util.Optional;

public interface CommentsRepository {

    public CommentModel createComment(CommentModel comment);

    public void deleteComment(CommentModel comment);

    public Optional<CommentModel> findById(CommentModel comment);

}
