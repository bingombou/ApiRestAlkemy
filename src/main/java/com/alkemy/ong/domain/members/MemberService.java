package com.alkemy.ong.domain.members;


import java.util.List;
import java.util.Optional;

public interface MemberService {

    List<MemberModel> getMembers();
    MemberModel createMember(MemberModel member);
    boolean deleteMember(Long id);
    MemberModel updateMember(MemberModel member);
}
