package com.alkemy.ong.domain.user;

import java.util.List;

public interface UserRepository {
    List<UserModel> getUsers();
}