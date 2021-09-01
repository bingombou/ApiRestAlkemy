package com.alkemy.ong.domain.model;


import lombok.Data;


@Data
public class UserModel {


    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    private RoleModel idRole;
}
