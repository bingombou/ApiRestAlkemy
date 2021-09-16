package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.SampleEntity;
import com.alkemy.ong.database.jparepositories.SampleJpaRepository;
import com.alkemy.ong.domain.exceptions.DomainException;
import com.alkemy.ong.domain.sample.Sample;
import com.alkemy.ong.domain.sample.SampleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Repository
public class DefaultSampleRepository implements SampleRepository {

    private final SampleJpaRepository jpaRepository;

    public DefaultSampleRepository(SampleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<Sample> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toModel)
                .collect(toList());
    }

    @Override
    public Sample create(Sample sample) {
        return toModel(jpaRepository.save(toEntity(sample)));
    }

    @Override
    public Sample update(Sample sample) {
        return null;
    }

    @Override
    public Optional<Sample> findById(Long id) {
        return jpaRepository.findById(id)
                .map(this::toModel);
    }

    private SampleEntity toEntity(Sample sample) {
        SampleEntity sampleEntity = new SampleEntity();
        sampleEntity.setName(sample.getName());
        sampleEntity.setDescription(sample.getDescription());
        return sampleEntity;
    }

    private Sample toModel(SampleEntity entity) {
        Sample sample = new Sample();
        sample.setId(entity.getId());
        sample.setName(entity.getName());
        sample.setDescription(entity.getDescription());
        return sample;
    }
}
