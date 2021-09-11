package com.alkemy.ong.domain.users;


import org.springframework.stereotype.Service;
import com.alkemy.ong.database.jparepositories.RoleJpaRepository;

@Service
public class DefaultRoleService implements RoleService {

    private RoleRepository roleRepository;

    public DefaultRoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleModel findById(long id){
        return roleRepository.findById(id);
    }
}