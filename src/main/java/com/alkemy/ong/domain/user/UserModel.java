package com.alkemy.ong.domain.user;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserModel {
    private Long idUser;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String photo;
    private boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long idRole;
}