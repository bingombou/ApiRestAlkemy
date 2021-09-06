package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.SlideEntity;
import com.alkemy.ong.database.jparepositories.SlideJpaRepository;
import com.alkemy.ong.domain.slide.SlideModel;
import com.alkemy.ong.domain.slide.SlideRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public  class DefaultSlideRepository implements SlideRepository {
    private SlideJpaRepository repository;

    public DefaultSlideRepository(SlideJpaRepository repository) {
        this.repository = repository;
    }

   private SlideModel toModel(SlideEntity entity) {
       return new SlideModel(
               entity.getId(),
               entity.getIdOrganization(),
               entity.getOrder(),
               entity.getText(),
               entity.getImageUrl(),
               entity.isDeleted(),
               entity.getCreatedAt(),
               entity.getUpdatedAt()
       );
    }

    @Override
    public List<SlideModel> getAll() {
        return repository.findAll().stream().map(s -> toModel(s)).collect(Collectors.toList());
    }
}

