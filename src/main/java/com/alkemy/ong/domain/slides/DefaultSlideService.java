package com.alkemy.ong.domain.slides;

import org.springframework.stereotype.Service;
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
    public SlideModel getDetails(int id) {
        final Optional<SlideModel> modelOptional = repository.getById(id);
        if (modelOptional.isEmpty()) {
            throw new SlideDomainException();
        }
        return modelOptional.get();
    }
}