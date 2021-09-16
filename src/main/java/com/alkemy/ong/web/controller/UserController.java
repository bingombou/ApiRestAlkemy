package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.users.UserModel;
import com.alkemy.ong.domain.users.UserService;
import com.alkemy.ong.web.dto.UserDto;
import com.alkemy.ong.web.dto.UserRegisterDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

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
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long idUser, @Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.updateUser(userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long idUser) {
            userService.deleteUser(idUser);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/auth/register")
    public ResponseEntity<UserRegisterDto> registerUserAccount(@Valid @RequestBody UserRegisterDto user){
        return new ResponseEntity<>(userService.registerUserAccount(user), HttpStatus.OK);
    }
}