package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.TestimonialEntity;
import com.alkemy.ong.database.jparepositories.TestimonialRepository;
import com.alkemy.ong.domain.testimonials.TestimonialModel;
import com.alkemy.ong.domain.testimonials.TestimonialRepo;
import org.springframework.stereotype.Repository;

@Repository
public class DefaultTestimonialRepository implements TestimonialRepo {

    private TestimonialRepository jpaRepo;

    public DefaultTestimonialRepository(TestimonialRepository jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    public TestimonialModel convertToModel(TestimonialEntity testimonialEntity){

        TestimonialModel testimonialModel = new TestimonialModel();

        testimonialModel.setId(testimonialEntity.getId());
        testimonialModel.setName(testimonialEntity.getName());
        testimonialModel.setImage(testimonialEntity.getImage());
        testimonialModel.setContent(testimonialEntity.getContent());
        testimonialModel.setDeleted(testimonialEntity.getDeleted());
        testimonialModel.setCreatedAt(testimonialModel.getCreatedAt());
        testimonialModel.setUpdatedAt(testimonialModel.getUpdatedAt());
        return testimonialModel;
    }

    public TestimonialModel create(TestimonialModel testimonialModel){

        TestimonialEntity testimonialEntity = new TestimonialEntity();

        testimonialEntity.setName(testimonialModel.getName());
        testimonialEntity.setImage(testimonialModel.getImage());
        testimonialEntity.setContent(testimonialModel.getContent());
        testimonialEntity.setDeleted(testimonialModel.getDeleted());
        testimonialEntity.setCreatedAt(testimonialModel.getCreatedAt());
        testimonialEntity.setUpdatedAt(testimonialModel.getUpdatedAt());

        testimonialEntity = jpaRepo.save(testimonialEntity);

        testimonialModel = convertToModel(testimonialEntity);
        return testimonialModel;
    }
}
