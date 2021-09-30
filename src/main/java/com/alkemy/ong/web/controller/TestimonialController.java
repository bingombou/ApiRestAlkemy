package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.testimonials.TestimonialModel;
import com.alkemy.ong.domain.testimonials.TestimonialService;
import com.alkemy.ong.domain.utils.Page;
import com.alkemy.ong.web.dto.PageDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import static com.alkemy.ong.commons.PageUtils.toPageDto;


@RestController
@RequestMapping ("/testimonials")
public class TestimonialController {
    private TestimonialService testimonialService;

    public TestimonialController(TestimonialService testimonialService){
        this.testimonialService = testimonialService;
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<TestimonialModel> create(@RequestBody TestimonialModel testimonialModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(testimonialService.save(testimonialModel));
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('Admin')")
    @PutMapping("/{testimonialModel.getId()}")
    public ResponseEntity<?> update(@RequestBody TestimonialModel testimonialModel){
        return ResponseEntity.ok(testimonialService.update(testimonialModel));
    }

    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    @PreAuthorize("hasAuthority('Admin')")
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
