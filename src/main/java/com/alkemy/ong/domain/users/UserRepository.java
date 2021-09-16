package com.alkemy.ong.domain.users;

import com.alkemy.ong.web.dto.UserDto;
import com.alkemy.ong.web.dto.UserRegisterDto;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserModel> getUsers();
    UserRegisterDto registerUserAccount(UserRegisterDto userRegisterDto);
    boolean findUserByEmail(String email);
    Optional<UserModel> getById(long idUser);
    UserDto updateUser(UserDto userDto);
    void deleteUser(long idUser);
}