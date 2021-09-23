package com.alkemy.ong.database.jparepositories;

import com.alkemy.ong.database.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentJpaRepository extends JpaRepository<CommentEntity, Integer> {

}
