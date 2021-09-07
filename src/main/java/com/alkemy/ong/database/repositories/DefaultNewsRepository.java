package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.NewsEntity;
import com.alkemy.ong.database.jparepositories.NewsJPARepository;
import com.alkemy.ong.domain.news.NewsModel;
import com.alkemy.ong.domain.news.NewsRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

@Repository
public class DefaultNewsRepository implements NewsRepository {

    NewsJPARepository jpaRepository;

    public DefaultNewsRepository(NewsJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public List<NewsModel> findAll() {
        List<NewsEntity> list = jpaRepository.findAll();
        return list.stream()
                .map(o -> this.toModel(o))
                .collect(Collectors.toList());
    }

    @Override
    public NewsModel findById(int id) {
        NewsEntity newsEntity = jpaRepository.findById(id);
        NewsModel newsModel = new NewsModel();
        newsModel.setId(newsEntity.getId());
        newsModel.setName(newsEntity.getName());
        newsModel.setContent(newsEntity.getContent());
        newsModel.setImage(newsEntity.getImage());
        newsModel.setCreatedAt(newsEntity.getCreated_at());
        newsModel.setUpdatedAt(newsEntity.getUpdated_at());
        return newsModel;
    }

    public NewsModel toModel(NewsEntity newsEntity) {
        NewsModel newsModel = new NewsModel();
        newsModel.setName(newsEntity.getName());
        newsModel.setContent(newsEntity.getContent());
        newsModel.setImage(newsEntity.getImage());

        return newsModel;
    }

}
