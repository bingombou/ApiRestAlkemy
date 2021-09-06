package com.alkemy.ong.database.jpaRepo;

import com.alkemy.ong.database.entities.TestimonialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository <TestimonialEntity, Long> {
}
