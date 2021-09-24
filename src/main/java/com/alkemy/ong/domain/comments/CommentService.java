package com.alkemy.ong.domain.comments;

import java.util.List;

public interface CommentService {

    public CommentModel createComment(CommentModel commentModel);

    public void deleteComment(CommentModel commentModel);
    List<String> getAllBodiesOrdered();
}
