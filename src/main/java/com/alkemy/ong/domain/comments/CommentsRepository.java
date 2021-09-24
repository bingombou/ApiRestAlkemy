package com.alkemy.ong.domain.comments;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository {
     void deleteComment(CommentModel comment);
     Optional<CommentModel> findById(CommentModel comment);
     CommentModel createComment(CommentModel commentModel);
     List<CommentModel> getAllOrdered();
}
