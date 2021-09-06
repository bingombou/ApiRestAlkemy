package com.alkemy.ong.domain.slide;

import org.springframework.stereotype.Service;
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
}