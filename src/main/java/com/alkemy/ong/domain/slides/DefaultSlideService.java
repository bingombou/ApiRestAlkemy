package com.alkemy.ong.domain.slides;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;


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
        return repository.getById(id).orElseThrow(() -> new SlideDomainException());
    }

    @Override
    public SlideModel update(SlideModel slide) {
        final SlideModel slideModel = repository.getById(slide.getId()).orElseThrow(() -> new SlideDomainException());
        slideModel.setIdOrganization(slide.getIdOrganization());
        slideModel.setOrder(slide.getOrder());
        slideModel.setImageUrl(slide.getImageUrl());
        slideModel.setText(slide.getText());
        slideModel.setDeleted(slide.isDeleted());
        slideModel.setUpdatedAt(LocalDateTime.now());
        return repository.update(slideModel);
    }

    @Override
    public void delete(int id) {
            repository.delete(getSlide(id));
    }
}