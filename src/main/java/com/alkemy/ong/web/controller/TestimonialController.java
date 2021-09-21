package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.testimonials.TestimonialModel;
import com.alkemy.ong.domain.testimonials.TestimonialService;
import com.alkemy.ong.domain.utils.Page;
import com.alkemy.ong.web.dto.PageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.alkemy.ong.commons.PageUtils.toPageDto;


@RestController
@RequestMapping ("/testimonials")
public class TestimonialController {
    private TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService){
        this.testimonialService = testimonialService;
    }

    @PostMapping
    public ResponseEntity<TestimonialModel> create(@RequestBody TestimonialModel testimonialModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonialService.save(testimonialModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody TestimonialModel testimonialModel, @PathVariable(value = "id") Long testimonialId){
        return ResponseEntity.ok(testimonialService.update(testimonialModel, testimonialId));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<?> delete(@PathVariable (value = "id") Long testimonialId){
        testimonialService.deleteById(testimonialId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<PageDto> findAll(@RequestParam int page){
        Page<TestimonialModel> testimonials = testimonialService.findAll(page);
        return ResponseEntity.ok(toPageDto(testimonials, "testimonials"));
    }
}
