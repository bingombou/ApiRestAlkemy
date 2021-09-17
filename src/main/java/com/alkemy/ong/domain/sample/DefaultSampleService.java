package com.alkemy.ong.domain.sample;

import com.alkemy.ong.domain.exceptions.DomainException;
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

    @Override
    public Sample create(Sample sample) {
        return repository.create(sample);
    }

    @Override
    public Sample update(Sample sample) {
        return repository.update(sample);
    }

    @Override
    public Sample findById(Long id) {
        return repository.findById(id).orElseThrow(DomainException::new);
    }
}
