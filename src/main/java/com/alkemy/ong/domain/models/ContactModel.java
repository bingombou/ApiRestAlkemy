package com.alkemy.ong.domain.models;

import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
public class ContactModel {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String message;
    private boolean deleted;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

