package com.alkemy.ong.domain.news;


import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;


@Data
public class NewsModel {

    private int id;
    private String name;
    private String image;
    private String content;
    private Date createdAt;
    private Date updatedAt;
    private String categoryId;


}


