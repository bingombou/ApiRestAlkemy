package com.alkemy.ong.domain.members;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<MemberModel> getMembers();
}
