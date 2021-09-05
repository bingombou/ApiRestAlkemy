package com.alkemy.ong.domain.models.activities;

import org.springframework.stereotype.Repository;

public interface ActivityRepository {

    public ActivityModel createActivity(ActivityModel activityModel);

}
