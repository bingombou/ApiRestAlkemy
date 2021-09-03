package com.alkemy.ong.database.repository;

import com.alkemy.ong.database.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
