package com.alkemy.ong.domain.member;

import com.alkemy.ong.domain.member.MemberModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<MemberModel> getMembers();
}
