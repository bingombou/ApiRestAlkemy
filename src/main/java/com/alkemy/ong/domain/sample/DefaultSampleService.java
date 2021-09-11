package com.alkemy.ong.domain.sample;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultSampleService implements SampleService {

    private final SampleRepository repository;

    public DefaultSampleService(SampleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Sample> findAll() {
        return repository.findAll();
    }
}
