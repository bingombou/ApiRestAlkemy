package com.alkemy.ong.domain.activities;

import org.springframework.stereotype.Service;

@Service
public class DefaultActivityService implements ActivityService {

    private ActivityRepository activityRepository;

    public DefaultActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public ActivityModel create(ActivityModel activityModel) {
        return activityRepository.createActivity(activityModel);
    }
}
