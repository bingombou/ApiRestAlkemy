package com.alkemy.ong.domain.users;

import java.util.List;

public interface UserService {
    List<UserModel> getUsers();
    void deleteUser(long idUser);
}