package com.alkemy.ong.web.dto;

import lombok.Data;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRegisterDto{
    @NotBlank(message = "Name field is required")
    private String firstName;

    @NotBlank(message = "Name field is required")
    private String lastName;

    @Email(message = "Email should be valid")
    private String email;

    @Size(min = 4, max = 8, message = "password must be between 4 and 8 characters")
    private String password;

    private Long idRole;
}