package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.models.activities.ActivityModel;
import com.alkemy.ong.domain.models.activities.ActivityService;
import com.alkemy.ong.web.dto.ActivityDto;
import com.alkemy.ong.web.exceptions.ApiUnprocessedEntity;
import com.alkemy.ong.web.exceptions.validator.ActivityValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActivityController {

    private ActivityService service;
    private ActivityValidator validator;

    public ActivityController(ActivityService service, ActivityValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @PostMapping("/activities")
    public ResponseEntity<Object> createActivity(@RequestBody ActivityModel activityModel) throws ApiUnprocessedEntity {

        validator.validateActivity(activityModel);
        this.service.create(activityModel);

        ActivityDto activityDto = new ActivityDto(activityModel);
        return new ResponseEntity<Object>(activityDto, HttpStatus.ACCEPTED);
    }
}
