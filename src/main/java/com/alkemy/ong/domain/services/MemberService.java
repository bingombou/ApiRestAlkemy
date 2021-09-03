package com.alkemy.ong.domain.services;

import com.alkemy.ong.domain.model.MemberModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {

    List<MemberModel> getMembers();
}
