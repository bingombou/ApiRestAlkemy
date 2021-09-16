package com.alkemy.ong.domain.sample;

import java.util.List;
import java.util.Optional;

public interface SampleService {
    List<Sample> findAll();

    Sample create(Sample sample);

    Sample update(Sample sample);

    Sample findById(Long id);
}
