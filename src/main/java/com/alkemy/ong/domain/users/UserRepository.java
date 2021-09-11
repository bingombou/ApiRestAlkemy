package com.alkemy.ong.domain.users;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<UserModel> getUsers();
    void deleteUser(long idUser);
    Optional<UserModel> getById(long idUser);
}