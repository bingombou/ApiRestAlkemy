package com.alkemy.ong.domain.members;

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

    public MemberModel createMember(MemberModel member){
        return memberRepository.createMember(member);
    }

}
