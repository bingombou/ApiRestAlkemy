package com.alkemy.ong.domain.member;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMemberService implements MemberService {

    private MemberRepository memberRepository;

    public DefaultMemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public List<MemberModel> getMembers(){
        return memberRepository.getMembers();
    }
}
