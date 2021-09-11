package com.alkemy.ong.web.controller;


import com.alkemy.ong.domain.members.MemberModel;
import com.alkemy.ong.domain.members.MemberService;
import com.alkemy.ong.web.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("members")
@RestController
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getMembers(){
        List<MemberDto> result =  memberService.getMembers().stream().map(m -> toDto(m)).collect(Collectors.toList());
        return new ResponseEntity<List<MemberDto>>(result, HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<MemberDto> createMember(@Valid @RequestBody MemberDto member){
         return new ResponseEntity<MemberDto>(this.toDto(memberService.createMember(toModel(member))), HttpStatus.CREATED) ;
    }

    private MemberDto toDto(MemberModel member){
        return new MemberDto(member.getId(), member.getName(), member.getFacebookUrl(), member.getInstagramUrl(),
            member.getLinkedinUrl(), member.getImage(), member.getDescription(), member.isDeleted(), member.getCreatedAt(), member.getUpdatedAt());
    }

    private MemberModel toModel(MemberDto mm){
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

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deleteMember(@PathVariable("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(path = "{member.getId()}")
    public ResponseEntity<MemberDto> updateMember(@Valid @RequestBody MemberModel member){
        memberService.updateMember(member);
        MemberDto memberDto = new MemberDto(member.getId(), member.getName(), member.getFacebookUrl(), member.getInstagramUrl(),
                member.getLinkedinUrl(), member.getImage(), member.getDescription(), member.isDeleted(), member.getCreatedAt(), member.getUpdatedAt());

        return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
    }

}