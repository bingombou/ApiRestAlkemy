package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.testimonials.TestimonialModel;
import com.alkemy.ong.domain.testimonials.TestimonialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestimonialController {
    private TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService){
        this.testimonialService = testimonialService;
    }

    @PostMapping("/testimonials")
    public ResponseEntity<TestimonialModel> create(@RequestBody TestimonialModel testimonialModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonialService.save(testimonialModel));
    }

}
