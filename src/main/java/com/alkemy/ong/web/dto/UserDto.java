package com.alkemy.ong.web.dto;

import com.alkemy.ong.domain.users.UserModel;
import lombok.Data;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
public class UserDto {
    @NotEmpty(message = "Name field is required")
    private String firstName;

    @NotEmpty(message = "Last Name field is required")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 4, max = 8, message = "password must be between 4 and 8 characters")
    private String password;

    private String photo;
    private LocalDateTime updatedAt;
    private Long idRole;
    public UserDto(){};

    public UserDto (UserModel userModel) {
        this.firstName = userModel.getFirstName();
        this.lastName = userModel.getLastName();
        this.email = userModel.getEmail();
        this.password = userModel.getPassword();
        this.photo = userModel.getPhoto();
        this.updatedAt = userModel.getUpdatedAt();
        this.idRole = userModel.getIdRole();
    }
}
