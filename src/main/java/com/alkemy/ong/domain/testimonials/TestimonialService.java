package com.alkemy.ong.domain.testimonials;

public interface TestimonialService {

    TestimonialModel save(TestimonialModel testimonialModel);

    TestimonialModel update(TestimonialModel testimonialModel, Long testimonialId);

    void deleteById(Long testimonialId);
}
