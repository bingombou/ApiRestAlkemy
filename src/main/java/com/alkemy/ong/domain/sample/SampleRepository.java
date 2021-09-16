package com.alkemy.ong.domain.sample;

import java.util.List;
import java.util.Optional;

public interface SampleRepository {
    List<Sample> findAll();

    Sample create(Sample sample);

    Sample update(Sample sample);

    Optional<Sample> findById(Long id);
}
