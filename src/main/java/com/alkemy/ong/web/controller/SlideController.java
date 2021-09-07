package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.slides.SlideModel;
import com.alkemy.ong.domain.slides.SlideService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private SlideDTO toDTO(SlideModel slideModel) {
        return new SlideDTO(slideModel.getImageUrl(), slideModel.getOrder());
    }

    @Setter
    @Getter
    @AllArgsConstructor
    private class SlideDTO {
        private String imageUrl;
        private int order;
    }
}
