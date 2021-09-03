package com.alkemy.ong.domain.implementations;

import com.alkemy.ong.database.repositories.MemberRepository;
import com.alkemy.ong.domain.model.MemberModel;
import com.alkemy.ong.domain.services.MemberService;

import java.util.*;

public class DefaultMemberService implements MemberService {

    private MemberRepository memberRepository;

    public List<MemberModel> getMembers(){
        return (List<MemberModel>) memberRepository.findAll();
    }
}
