package com.alkemy.ong.database.entities;


import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE idUser=?")
@FilterDef(name = "deletedUserFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedUserFilter", condition = "deleted = :isDeleted")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @NotEmpty(message = "The first name field is required")
    @Column(name = "firstName", length = 30, nullable = false)
    private String firstName;

    @NotEmpty(message = "The last name field is required")
    @Column(name = "lastName", length = 30, nullable = false)
    private String lastName;

    @NotEmpty(message = "The email field is required")
    @Column(name = "email", length = 20, nullable = false, unique = true)
    private String email;

    @NotEmpty(message = "The password field is required")
    @Column(name = "password", length=8, nullable = false)
    private String password;

    @Column(name = "photo", length=30, nullable = true)
    private String photo;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = Boolean.FALSE;

    @Column(name= "createdAt", nullable=false)
    private LocalDate createdAt;

    @Column(name= "lastModified", nullable=false)
    private LocalDate lastModified;
}
