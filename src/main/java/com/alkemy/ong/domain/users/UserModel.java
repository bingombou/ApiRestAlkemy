package com.alkemy.ong.domain.users;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserModel {
    private long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private RoleModel idRole;

    public UserModel() {
    }

    public UserModel(String firstName, String lastName, String email, String password, RoleModel idRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }
}