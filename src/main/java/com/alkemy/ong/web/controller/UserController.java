package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.users.UserModel;
import com.alkemy.ong.domain.users.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers(){
        try {
            List<UserModel> users = userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long idUser, @Valid @RequestBody UserModel userModel) {
        return new ResponseEntity<>(toDto(userService.updateUser(userModel)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long idUser) {
        userService.deleteUser(idUser);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserRegisterDto> registerUserAccount(@Valid @RequestBody UserModel userModel){
        return new ResponseEntity<>(toRegisterDto(userService.registerUserAccount(userModel)), HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ResponseDtoLogin> loginUser(@Valid @RequestBody UserModel userModel){
        return new ResponseEntity<>(toDtoLogin(userService.loginUser(userModel)),HttpStatus.OK);
    }

    @Data
    @AllArgsConstructor
    private class ResponseDtoLogin{

        @NotEmpty(message = "Name field is required")
        private String firstName;

        @NotEmpty(message = "Last Name field is required")
        private String lastName;

        @Email(message = "Email should be valid")
        private String email;

        @Size(min = 4, max = 8, message = "password must be between 4 and 8 characters")
        private String password;

        private String role;
    }

    private ResponseDtoLogin toDtoLogin(UserModel userModel){
        return new ResponseDtoLogin(
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getIdRole().getName()
        );
    }

    @Data
    @AllArgsConstructor
    private class UserDto{
        private Long idUser;

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
    }

    @Data
    @AllArgsConstructor
    private class UserRegisterDto{
        @NotBlank(message = "Name field is required")
        private String firstName;

        @NotBlank(message = "Name field is required")
        private String lastName;

        @Email(message = "Email should be valid")
        private String email;

        @Size(min = 4, max = 8, message = "password must be between 4 and 8 characters")
        private String password;
    }

    private UserDto toDto(UserModel userModel){
        return new UserDto(
                userModel.getIdUser(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getPhoto(),
                userModel.getUpdatedAt(),
                userModel.getIdRole().getIdRole());
    }

    private UserRegisterDto toRegisterDto(UserModel userModel){
        return new UserRegisterDto(
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getEmail(),
                userModel.getPassword());
    }
}