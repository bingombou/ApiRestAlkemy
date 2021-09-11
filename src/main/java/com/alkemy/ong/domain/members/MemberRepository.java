package com.alkemy.ong.domain.members;

import com.alkemy.ong.database.entities.MemberEntity;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    List<MemberModel> getMembers();
    MemberModel createMember(MemberModel member);
    void deleteMember(Long id);
    MemberModel updateMember(MemberModel member);
    Optional<MemberEntity> findById(Long id);
}
