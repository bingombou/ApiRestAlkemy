package com.alkemy.ong.web.exceptions.validator;

import com.alkemy.ong.domain.models.activities.ActivityModel;
import com.alkemy.ong.web.exceptions.ApiUnprocessedEntity;
import org.springframework.stereotype.Component;

@Component
public class DefaultActivityValidator implements ActivityValidator {

    @Override
    public void validateActivity(ActivityModel request) throws ApiUnprocessedEntity {

        if (request.getContent().isEmpty() || request.getContent().isBlank() || request.getContent() == null) {
            this.message("This field is required");
        }
        if (request.getName().isEmpty() || request.getName().isBlank() || request.getName() == null) {
            this.message("This field is required");
        }
        if (request.getImage().isEmpty() || request.getImage().isBlank() || request.getImage() == null) {
            this.message("This field is required");
        }

    }

    private void message(String message) throws ApiUnprocessedEntity {
        throw new ApiUnprocessedEntity(message);
    }
}
