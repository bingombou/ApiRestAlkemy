package com.alkemy.ong.web.exceptions.validator;

import com.alkemy.ong.domain.models.activities.ActivityModel;
import com.alkemy.ong.web.exceptions.ApiUnprocessedEntity;
import org.springframework.stereotype.Service;

@Service
public interface ActivityValidator {

    public void validateActivity(ActivityModel request) throws ApiUnprocessedEntity;

}
