package com.alkemy.ong.domain.model;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityModel {

    private String name;
    private String content;
    private String image;
    private Date created_at;
    private Date updated_at;
}
