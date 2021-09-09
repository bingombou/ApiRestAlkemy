package com.alkemy.ong.domain.members;

import java.util.List;

public interface MemberRepository {

    List<MemberModel> getMembers();
    MemberModel createMember(MemberModel member);
}
