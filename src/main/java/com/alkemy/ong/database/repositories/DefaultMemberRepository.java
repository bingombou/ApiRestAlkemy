package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.MemberEntity;
import com.alkemy.ong.database.jparepositories.MemberJPARepository;
import com.alkemy.ong.domain.members.MemberDomainException;
import com.alkemy.ong.domain.members.MemberModel;
import com.alkemy.ong.domain.members.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultMemberRepository implements MemberRepository {

    private MemberJPARepository memberRepository;

    public DefaultMemberRepository(MemberJPARepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberModel> getMembers() {
        List<MemberEntity> members = memberRepository.findAll();
        return members.stream().map(MemberEntity -> toModel(MemberEntity)).collect(Collectors.toList());
    }

    public MemberModel createMember(MemberModel member) {
        memberRepository.save(this.toEntity(member));
        return member;
    }

    private MemberEntity toEntity(MemberModel mm) {
        MemberEntity member = new MemberEntity();
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

    public boolean deleteMember(Long id) {
        boolean deleted = false;
        if (memberRepository.findById(id) != null) {
            memberRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

    public MemberModel updateMember(MemberModel member){
        Optional<MemberEntity> result = memberRepository.findById(member.getId());
        if(!result.isEmpty())
            memberRepository.save(toEntity(member));

        return toModel(result.orElseThrow(MemberDomainException::new));

    }

    public Optional<MemberEntity> findById(Long id){
        return memberRepository.findById(id);
    }
}