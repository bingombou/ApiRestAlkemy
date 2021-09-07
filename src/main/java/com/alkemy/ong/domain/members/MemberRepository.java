package com.alkemy.ong.domain.members;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    List<MemberModel> getMembers();
}
