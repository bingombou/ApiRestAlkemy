package com.alkemy.ong.database.jparepositories;

import com.alkemy.ong.database.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepository  extends JpaRepository<CommentEntity, Integer> {
}
