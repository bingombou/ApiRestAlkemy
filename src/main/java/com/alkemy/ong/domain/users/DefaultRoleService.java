package com.alkemy.ong.domain.users;

import com.alkemy.ong.database.jparepositories.RoleJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultRoleService implements RoleService {

    private RoleJpaRepository roleJpaRepository;

    public DefaultRoleService(RoleJpaRepository roleJpaRepository) {
        this.roleJpaRepository = roleJpaRepository;
    }
}