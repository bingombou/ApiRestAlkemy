package com.alkemy.ong.domain.testimonials;

public interface TestimonialRepo {

    TestimonialModel create(TestimonialModel testimonialModel);

    void deleteByTestimonialId(Long testimonialId);
}
