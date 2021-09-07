package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.UserEntity;
import com.alkemy.ong.database.jparepositories.UserJpaRepository;
import com.alkemy.ong.domain.user.UserModel;
import com.alkemy.ong.domain.user.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DefaultUserRepository implements UserRepository {

    private UserJpaRepository userJpaRepository;

    public DefaultUserRepository(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    public List<UserModel> getUsers(){
        return userJpaRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public UserModel toModel(UserEntity userEntity){
        UserModel userModel = new UserModel();

        userModel.setIdUser(userEntity.getIdUser());
        userModel.setDeleted(userEntity.isDeleted());
        userModel.setCreatedAt(userEntity.getCreatedAt());
        userModel.setEmail(userEntity.getEmail());
        userModel.setFirstName(userEntity.getFirstName());
        userModel.setIdRole(userEntity.getRoleId().getIdRole());
        userModel.setLastName(userEntity.getLastName());
        userModel.setPassword(userEntity.getPassword());
        userModel.setPhoto(userEntity.getPhoto());
        userModel.setUpdatedAt(userEntity.getUpdatedAt());

        return userModel;
    }
}