package com.alkemy.ong.database.jpaRepositories;

import com.alkemy.ong.database.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesJpaRepo extends JpaRepository<CategoriesEntity, Long> {

}
