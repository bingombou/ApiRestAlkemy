package com.alkemy.ong.domain.model;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class UserModel {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    private boolean deleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private RoleModel idRole;
}
