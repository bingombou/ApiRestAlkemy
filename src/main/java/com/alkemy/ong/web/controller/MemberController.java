package com.alkemy.ong.web.controller;


import com.alkemy.ong.domain.members.MemberModel;
import com.alkemy.ong.domain.members.MemberService;
import com.alkemy.ong.web.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<MemberDto> createMember(@RequestBody MemberModel member){
         return new ResponseEntity<MemberDto>(this.toDto(memberService.createMember(member)), HttpStatus.CREATED) ;
    }

    private MemberDto toDto(MemberModel member){
        return new MemberDto(member.getId(), member.getName(), member.getFacebookUrl(), member.getInstagramUrl(),
            member.getLinkedinUrl(), member.getImage(), member.getDescription(), member.isDeleted(), member.getCreatedAt(), member.getUpdatedAt());
    }

}