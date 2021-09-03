package com.alkemy.ong.database.repositories;

import com.alkemy.ong.domain.model.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel, Long> {

}
