package com.alkemy.ong.web;

import com.alkemy.ong.domain.slide.SlideModel;
import com.alkemy.ong.domain.slide.SlideService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SlidesController {
    private SlideService service;

    public SlidesController(SlideService service) {
        this.service = service;
    }

    @GetMapping("/slide")
    public List<SlideDTO> getAllSlides() {
        return service.getAll().stream().map(s -> ToDTO(s)).collect(Collectors.toList());
    }

    private SlideDTO ToDTO(SlideModel slideModel) {
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