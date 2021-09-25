package com.alkemy.ong.domain.comments;

import java.util.List;

public interface CommentService {

    CommentModel createComment(CommentModel commentModel);

    void deleteComment(CommentModel commentModel);

    List<String> getAllBodiesOrdered();

    List<CommentModel> getCommentByIdOfNews(int id);
}
