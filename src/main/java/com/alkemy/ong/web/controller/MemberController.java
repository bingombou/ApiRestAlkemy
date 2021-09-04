package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.member.MemberModel;
import com.alkemy.ong.domain.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    //returns a list of all members
    @GetMapping(path = "members")
    public List<MemberModel> getMembers(){
        return memberService.getMembers();
    }

}
