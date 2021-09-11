package com.alkemy.ong.database.jparepositories;

import com.alkemy.ong.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByEmail(String email);
}