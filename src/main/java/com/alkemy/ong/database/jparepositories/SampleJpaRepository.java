package com.alkemy.ong.database.jparepositories;

import com.alkemy.ong.database.entities.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SampleJpaRepository extends JpaRepository<SampleEntity, Long> {
}
