package com.alkemy.ong.domain.users;

import java.util.List;

public interface UserRepository {
    List<UserModel> getUsers();
}