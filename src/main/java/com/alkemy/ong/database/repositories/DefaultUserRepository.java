package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.UserEntity;
import com.alkemy.ong.database.jparepositories.UserJpaRepository;
import com.alkemy.ong.domain.users.UserModel;
import com.alkemy.ong.domain.users.UserRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
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

    public void deleteUser(long idUser){
        Optional<UserEntity> user  = userJpaRepository.findById(idUser);
        user.get().setDeleted(true);
        userJpaRepository.save(user.get());
    }

    public Optional<UserModel> getById(long idUser) {
        Optional<UserEntity> userEntity = userJpaRepository.findById(idUser);
        return (userEntity.isPresent()) ? Optional.of(toModel(userEntity.get())) : Optional.empty();
    }



}