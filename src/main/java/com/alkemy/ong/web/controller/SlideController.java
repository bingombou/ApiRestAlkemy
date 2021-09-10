package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.slides.SlideModel;
import com.alkemy.ong.domain.slides.SlideService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SlideController {
    private SlideService service;

    public SlideController(SlideService service) {
        this.service = service;
    }

    @GetMapping("/slide")
    public List<SlideDTO> getAllSlides() {
        return service.getAll().stream().map(s -> toDTO(s)).collect(Collectors.toList());
    }

    @GetMapping("/slide/{id}")
    public ResponseEntity<FullSlideDTO> getDetails(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(toFullSlideDTO(service.getSlide(id)));
    }

    @PutMapping("/slide/{id}")
    public ResponseEntity<FullSlideDTO> update(@PathVariable("id") @RequestBody SlideModel slide) {
        return ResponseEntity.ok(toFullSlideDTO(service.update(slide)));
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
                slideModel.getImageUrl()
        );
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
