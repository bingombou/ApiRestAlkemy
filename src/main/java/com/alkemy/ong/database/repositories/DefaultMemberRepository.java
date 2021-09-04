package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.MemberEntity;
import com.alkemy.ong.database.jparepositories.MemberJPARepository;
import com.alkemy.ong.domain.member.MemberModel;
import com.alkemy.ong.domain.member.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultMemberRepository implements MemberRepository {

    private MemberJPARepository memberRepository;

    public DefaultMemberRepository(MemberJPARepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberModel> getMembers() {
        List<MemberEntity> members = memberRepository.findAll();
        List<MemberModel> retorno = new ArrayList<>();
        for (MemberEntity mm : members){
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
            retorno.add(member);
        }
        return retorno;
    }
}
