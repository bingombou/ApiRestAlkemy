package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.ActivityEntity;
import com.alkemy.ong.database.jparepositories.ActivityJpaRepository;
import com.alkemy.ong.domain.activities.ActivityModel;
import com.alkemy.ong.domain.activities.ActivityRepository;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultActivityRepository implements ActivityRepository {

    private ActivityJpaRepository activityRepository;

    public DefaultActivityRepository(ActivityJpaRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public ActivityModel createActivity(ActivityModel activityModel) {

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(activityModel.getName());
        activityEntity.setContent(activityModel.getContent());
        activityEntity.setImage(activityModel.getImage());

        this.activityRepository.save(activityEntity);

        return activityModel;
    }

}
