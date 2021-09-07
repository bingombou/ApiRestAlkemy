package com.alkemy.ong.database.entities;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @NotEmpty(message = "The name field is required")
    @Column(name = "name", length = 15, nullable = false)
    private String name;

    @NotEmpty(message = "The description field is required")
    @Column(name = "description", length = 30, nullable = true)
    private String description;

    @Column(name= "createdAt", nullable=false)
    private Timestamp createdAt;

    @Column(name= "updateAt", nullable=false)
    private Timestamp updateAt;

    @OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserEntity> users;
}