package com.alkemy.ong.domain.testimonials;

public interface TestimonialRepo {

    TestimonialModel create(TestimonialModel testimonialModel);

    TestimonialModel updateTestimonial(TestimonialModel testimonialModel, Long testimonialId);

    void deleteByTestimonialId(Long testimonialId);
}
