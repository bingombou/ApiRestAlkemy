package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.TestimonialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository extends JpaRepository<TestimonialEntity, Long> {
}
