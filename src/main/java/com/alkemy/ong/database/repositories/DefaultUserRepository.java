package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.RoleEntity;
import com.alkemy.ong.database.entities.UserEntity;
import com.alkemy.ong.database.jparepositories.RoleJpaRepository;
import com.alkemy.ong.database.jparepositories.UserJpaRepository;
import com.alkemy.ong.domain.users.UserModel;
import com.alkemy.ong.domain.users.UserRepository;
import com.alkemy.ong.web.dto.UserDto;
import com.alkemy.ong.web.dto.UserRegisterDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultUserRepository implements UserRepository {

    private UserJpaRepository userJpaRepository;
    private RoleJpaRepository roleJpaRepository;
    PasswordEncoder encoder;

    public DefaultUserRepository(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository, PasswordEncoder encoder) {
        this.userJpaRepository = userJpaRepository;
        this.roleJpaRepository = roleJpaRepository;
        this.encoder = encoder;
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
    public UserDto toDto(UserEntity userEntity){
        UserDto userDto = new UserDto();

        userDto.setEmail(userEntity.getEmail());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setIdRole(userEntity.getRoleId().getIdRole());
        userDto.setLastName(userEntity.getLastName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setPhoto(userEntity.getPhoto());
        userDto.setUpdatedAt(userEntity.getUpdatedAt());

        return userDto;
    }
    public UserDto updateUser(long idUser, UserDto userDto){
        Optional<UserEntity> oldUser  = userJpaRepository.findById(idUser);

        oldUser.get().setEmail(userDto.getEmail());
        oldUser.get().setFirstName(userDto.getFirstName());
        oldUser.get().setLastName(userDto.getLastName());
        oldUser.get().setPassword(userDto.getPassword());
        oldUser.get().setPhoto(userDto.getPhoto());
        oldUser.get().setUpdatedAt(userDto.getUpdatedAt());

        userJpaRepository.save(oldUser.get());

        return toDto(oldUser.get());
    }
    public boolean findUserByEmail(String email){
        return userJpaRepository.findByEmail(email) != null;
    }

    public UserRegisterDto registerUserAccount (UserRegisterDto user){
        UserEntity userEntity = new UserEntity();
        RoleEntity role = roleJpaRepository.findById(1);
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(encoder.encode(user.getPassword()));
        userEntity.setRoleId(role);
        userJpaRepository.save(userEntity);
        return toDtoRegisterUser(userEntity);
    }

    public UserRegisterDto toDtoRegisterUser(UserEntity userEntity){
        UserRegisterDto user = new UserRegisterDto();

        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setEmail(userEntity.getEmail());
        user.setPassword(userEntity.getPassword());
        user.setIdRole(userEntity.getRoleId().getIdRole());
        return user;
    }
}