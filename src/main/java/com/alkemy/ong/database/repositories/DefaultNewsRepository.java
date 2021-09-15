package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.NewsEntity;
import com.alkemy.ong.database.jparepositories.NewsJPARepository;
import com.alkemy.ong.domain.news.NewsModel;
import com.alkemy.ong.domain.news.NewsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class DefaultNewsRepository implements NewsRepository {

    private NewsJPARepository newsRepository;

    public DefaultNewsRepository(NewsJPARepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsModel> getNews() {
        List<NewsEntity> news = newsRepository.findAll();
        return news.stream()
                .map(o -> this.toModel(o))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<NewsEntity> findById(Long id) {
        return newsRepository.findById(id);
    }


    public NewsModel createNews(NewsModel news) {
        newsRepository.save(this.toEntity(news));
        return news;
    }
    private NewsEntity toEntity(NewsModel newsModel) {
        NewsEntity news = new NewsEntity();
        news.setId(newsModel.getId());
        news.setName(newsModel.getName());
        news.setContent(newsModel.getContent());
        news.setImage(newsModel.getImage());
        news.setDeleted(newsModel.isDeleted());
        news.setCreatedAt(newsModel.getCreatedAt());
        news.setUpdatedAt(newsModel.getUpdatedAt());
        return news;
    }

    private NewsModel toModel(NewsEntity newsEntity) {
        NewsModel newsModel = new NewsModel();
        newsModel.setName(newsEntity.getName());
        newsModel.setContent(newsEntity.getContent());
        newsModel.setImage(newsEntity.getImage());

        return newsModel;
    }


}
