package com.alkemy.ong.domain.users;

import java.util.List;

public interface UserService {
    List<UserModel> getUsers();
    UserModel registerUserAccount(UserModel userModel);
    UserModel updateUser(UserModel userModel);
    void deleteUser(long idUser);
    UserModel loginUser(UserModel userModel);
}