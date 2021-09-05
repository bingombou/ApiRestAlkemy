package com.alkemy.ong.web.dto;

import com.alkemy.ong.domain.models.activities.ActivityModel;
import lombok.Data;

@Data
public class ActivityDto {

    private String name;
    private String content;
    private String image;

    public ActivityDto(ActivityModel model ) {
        this.content = model.getContent();
        this.name = model.getImage();
        this.image = model.getImage();
    }
}
