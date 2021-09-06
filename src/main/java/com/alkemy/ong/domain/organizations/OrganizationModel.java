package com.alkemy.ong.domain.organizations;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrganizationModel {

    private String name;
    private String image;
    private String address;
    private Integer phone;
    private String email;
    private String welcomeText;
    private String aboutUsText;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean deleted = false;

}
