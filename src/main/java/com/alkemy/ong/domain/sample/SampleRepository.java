package com.alkemy.ong.domain.sample;

import java.util.List;

public interface SampleRepository {
    List<Sample> findAll();

    Sample create(Sample sample);

    Sample update(Sample sample);

    Sample findById(Long id);
}
