package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.TestimonialEntity;
import com.alkemy.ong.database.jparepositories.TestimonialJpaRepository;
import com.alkemy.ong.domain.testimonials.TestimonialModel;
import com.alkemy.ong.domain.testimonials.TestimonialRepo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DefaultTestimonialRepository implements TestimonialRepo {

    private TestimonialJpaRepository testimonialJpaRepository;

    public DefaultTestimonialRepository(TestimonialJpaRepository testimonialJpaRepository){
        this.testimonialJpaRepository = testimonialJpaRepository;
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

    @Override
    public TestimonialModel create(TestimonialModel testimonialModel){

        TestimonialEntity testimonialEntity = new TestimonialEntity();

        testimonialEntity.setName(testimonialModel.getName());
        testimonialEntity.setImage(testimonialModel.getImage());
        testimonialEntity.setContent(testimonialModel.getContent());
        testimonialEntity.setDeleted(testimonialModel.getDeleted());
        testimonialEntity.setCreatedAt(testimonialModel.getCreatedAt());
        testimonialEntity.setUpdatedAt(testimonialModel.getUpdatedAt());

        testimonialEntity = testimonialJpaRepository.save(testimonialEntity);

        testimonialModel = convertToModel(testimonialEntity);
        return testimonialModel;
    }

    @Override
    public TestimonialModel updateTestimonial(TestimonialModel testimonialModel, Long testimonialId) {

        Optional<TestimonialEntity> testimonial = testimonialJpaRepository.findById(testimonialId);

        testimonial.get().setName(testimonialModel.getName());
        testimonial.get().setImage(testimonialModel.getImage());
        testimonial.get().setContent(testimonialModel.getContent());
        testimonial.get().setDeleted(testimonialModel.getDeleted());
        testimonial.get().setCreatedAt(testimonialModel.getCreatedAt());
        testimonial.get().setUpdatedAt(testimonialModel.getUpdatedAt());

        testimonialJpaRepository.save(testimonial.get());

        testimonialModel = convertToModel(testimonial.get());

        return testimonialModel;
    }


    @Override
    public void deleteByTestimonialId(Long testimonialId) {
        testimonialJpaRepository.deleteById(testimonialId);
    }
}
