package com.alkemy.ong.database.jparepositories;

import com.alkemy.ong.database.entities.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlideJpaRepository extends JpaRepository<SlideEntity, Integer> {
    SlideEntity save(SlideEntity entity);
}
