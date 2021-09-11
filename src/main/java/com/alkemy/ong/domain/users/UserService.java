package com.alkemy.ong.domain.users;

import com.alkemy.ong.web.dto.UserDto;
import com.alkemy.ong.web.dto.UserRegisterDto;
import java.util.List;

public interface UserService {
    List<UserModel> getUsers();
    UserRegisterDto registerUserAccount(UserRegisterDto userRegisterDto);
    UserDto updateUser(long idUser, UserDto userDto);
    void deleteUser(long idUser);
}