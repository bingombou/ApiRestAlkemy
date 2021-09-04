package com.alkemy.ong.domain.member;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {

    List<MemberModel> getMembers();
}
