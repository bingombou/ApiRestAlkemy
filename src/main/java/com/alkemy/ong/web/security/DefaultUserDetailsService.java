package com.alkemy.ong.web.security;

import com.alkemy.ong.database.entities.UserEntity;
import com.alkemy.ong.database.jparepositories.UserJpaRepository;
import com.alkemy.ong.domain.exceptions.DomainException;
import com.alkemy.ong.domain.users.RoleModel;
import com.alkemy.ong.domain.users.RoleRepository;
import com.alkemy.ong.domain.users.UserModel;
import com.alkemy.ong.domain.users.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public DefaultUserDetailsService(@Lazy UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> userModel = userRepository.findUserByEmail(email);
        if(userModel.isEmpty()){
            throw new DomainException("Email not found " + userModel.get().getEmail());
        }
        return DefaultUserDetails.build(userModel.get());
    }

    public UserModel toModel(UserEntity userEntity){
        UserModel userModel = new UserModel();
        RoleModel roleModel = roleRepository.findById(userEntity.getRoleId().getIdRole());
        userModel.setIdUser(userEntity.getIdUser());
        userModel.setDeleted(userEntity.isDeleted());
        userModel.setCreatedAt(userEntity.getCreatedAt());
        userModel.setEmail(userEntity.getEmail());
        userModel.setFirstName(userEntity.getFirstName());
        userModel.setIdRole(roleModel);
        userModel.setLastName(userEntity.getLastName());
        userModel.setPassword(userEntity.getPassword());
        userModel.setPhoto(userEntity.getPhoto());
        userModel.setUpdatedAt(userEntity.getUpdatedAt());
        return userModel;
    }
}