package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.slides.SlideModel;
import com.alkemy.ong.domain.slides.SlideService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
public class SlideController {
    private SlideService service;

    public SlideController(SlideService service) {
        this.service = service;
    }

    @GetMapping("admin/slide")
    public List<SlideDTO> getAllSlides() {
        return service.getAll()
                .stream()
                .map(this::toDTO).collect(toList());
    }

    @GetMapping("admin/slide/{id}")
    public ResponseEntity<FullSlideDTO> getDetails(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(toFullSlideDTO(service.getSlide(id)));
    }

    @PutMapping("admin/slide/{id}")
    public ResponseEntity<FullSlideDTO> update(@PathVariable("id") int id, @RequestBody SlideModel slide) {
        return ResponseEntity.ok(toFullSlideDTO(service.update(slide)));
    }


    @DeleteMapping("admin/slide/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("slide/{orgId}")
    public ResponseEntity<List<FullSlideDTO>> getAllByOrgId(@PathVariable("orgId") Integer orgId) {
        return ResponseEntity.ok(service.getAllByOrgIdOrdered(orgId)
                .stream()
                .map(this::toFullSlideDTO)
                .collect(toList()));
    }

    @PostMapping("admin/slide")
    public ResponseEntity<FullSlideDTO> create(@RequestBody SlideModel slide) {
            return ResponseEntity.status(HttpStatus.CREATED).body(toFullSlideDTO(service.create(slide)));
    }

    private SlideDTO toDTO(SlideModel slideModel) {
        return new SlideDTO(slideModel.getImageUrl(), slideModel.getOrder());
    }

    private FullSlideDTO toFullSlideDTO(SlideModel slideModel) {
        return new FullSlideDTO(
                slideModel.getId(),
                slideModel.getIdOrganization(),
                slideModel.getOrder(),
                slideModel.getText(),
                slideModel.getImageUrl());
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class FullSlideDTO {
        private int id;
        private int idOrganization;
        private int order;
        private String text;
        private String imageUrl;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class SlideDTO {
        private String imageUrl;
        private int order;
    }
}
