package com.alkemy.ong.domain.members;

import com.alkemy.ong.database.entities.MemberEntity;
import com.alkemy.ong.web.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultMemberService implements MemberService {

    private MemberRepository memberRepository;

    public DefaultMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<MemberModel> getMembers() {
        return memberRepository.getMembers();
    }

    public MemberModel createMember(MemberModel member) {
        return memberRepository.createMember(member);
    }

    public boolean deleteMember(Long id) {
        return memberRepository.deleteMember(id);
    }

    private MemberModel toModel(MemberEntity mm) {
        MemberModel member = new MemberModel();
        member.setId(mm.getId());
        member.setName(mm.getName());
        member.setCreatedAt(mm.getCreatedAt());
        member.setDeleted(mm.isDeleted());
        member.setDescription(mm.getDescription());
        member.setFacebookUrl(mm.getFacebookUrl());
        member.setImage(mm.getImage());
        member.setInstagramUrl(mm.getInstagramUrl());
        member.setLinkedinUrl(mm.getLinkedinUrl());
        member.setUpdatedAt(mm.getUpdatedAt());
        return member;
    }

    public MemberModel updateMember(MemberModel member) {
        Optional<MemberEntity> result = memberRepository.findById(member.getId());
        /*if (result.isEmpty()) {
            throw new MemberDomainException();
        }*/
        memberRepository.updateMember(member);
        return toModel(result.orElseThrow(MemberDomainException::new));
    }
}
