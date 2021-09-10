package com.alkemy.ong.domain.slides;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DefaultSlideService implements SlideService {
    private SlideRepository repository;

    public DefaultSlideService(SlideRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SlideModel> getAll() {
        return repository.getAll();
    }

    @Override
    public SlideModel getSlide(int id) {
        final Optional<SlideModel> modelOptional = repository.getById(id);
        if (modelOptional.isEmpty()) {
            throw new SlideDomainException();
        }
        return modelOptional.get();
    }

    @Override
    public SlideModel update(SlideModel slide) {
        repository.getById(slide.getId()).orElseThrow(() -> new SlideDomainException());
        slide.setIdOrganization(slide.getIdOrganization());
        slide.setOrder(slide.getOrder());
        slide.setImageUrl(slide.getImageUrl());
        slide.setText(slide.getText());
        slide.setDeleted(slide.isDeleted());
        slide.setUpdatedAt(LocalDateTime.now());
        return repository.update(slide);
    }
}