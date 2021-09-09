package com.alkemy.ong.domain.members;

import java.util.List;

public interface MemberService {

    List<MemberModel> getMembers();
    MemberModel createMember(MemberModel member);
}
