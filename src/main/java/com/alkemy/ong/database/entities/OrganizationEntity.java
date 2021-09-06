package com.alkemy.ong.database.entities;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "organizations")
@Data
@SQLDelete(sql = "UPDATE organizations SET deleted = true WHERE id=?")
@FilterDef(name = "deletedOrganizationFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedProductFilter", condition = "deleted = :isDeleted")
public class OrganizationEntity implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name field is required")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    @NotEmpty(message = "Image field is required")
    private String image;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "phone", nullable = true)
    private Integer phone;

    @Column(name = "email", nullable = false)
    @NotEmpty(message = "Email field is required")
    private String email;

    @Column(name = "welcomeText", nullable = false)
    @NotEmpty(message = "WelcomeText field is required")
    private String welcomeText;

    @Column(name = "aboutUsText", nullable = true)
    private String aboutUsText;

    @Column(name = "createAt", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updateAt", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted")
    private boolean deleted = false;
}
