package com.alkemy.ong.domain.testimonials;

import org.springframework.stereotype.Service;

@Service
public class DefaultTestimonialService implements TestimonialService{

    private TestimonialRepo testimonialRepo;

    public DefaultTestimonialService(TestimonialRepo testimonialRepo){
        this.testimonialRepo = testimonialRepo;
    }

    @Override
    public TestimonialModel save(TestimonialModel testimonialModel) {
        return testimonialRepo.create(testimonialModel);
    }

    @Override
    public void deleteById(Long testimonialId) {
        try {
            testimonialRepo.deleteByTestimonialId(testimonialId);
        } catch (RuntimeException e){
            throw new TestimonialDomainException();
        }
    }


}
