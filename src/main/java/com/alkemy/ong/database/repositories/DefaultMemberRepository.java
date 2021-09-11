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

    private MemberEntity toEntity(MemberModel memberModel) {
        MemberEntity member = new MemberEntity();
        member.setId(memberModel.getId());
        member.setName(memberModel.getName());
        member.setCreatedAt(memberModel.getCreatedAt());
        member.setDeleted(memberModel.isDeleted());
        member.setDescription(memberModel.getDescription());
        member.setFacebookUrl(memberModel.getFacebookUrl());
        member.setImage(memberModel.getImage());
        member.setInstagramUrl(memberModel.getInstagramUrl());
        member.setLinkedinUrl(memberModel.getLinkedinUrl());
        member.setUpdatedAt(memberModel.getUpdatedAt());
        return member;
    }


    private MemberModel toModel(MemberEntity memberEntity) {
        MemberModel member = new MemberModel();
        member.setId(memberEntity.getId());
        member.setName(memberEntity.getName());
        member.setCreatedAt(memberEntity.getCreatedAt());
        member.setDeleted(memberEntity.isDeleted());
        member.setDescription(memberEntity.getDescription());
        member.setFacebookUrl(memberEntity.getFacebookUrl());
        member.setImage(memberEntity.getImage());
        member.setInstagramUrl(memberEntity.getInstagramUrl());
        member.setLinkedinUrl(memberEntity.getLinkedinUrl());
        member.setUpdatedAt(memberEntity.getUpdatedAt());
        return member;
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
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