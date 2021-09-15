package com.alkemy.ong.domain.news;

import com.alkemy.ong.database.entities.NewsEntity;

import java.util.List;
import java.util.Optional;


public interface NewsRepository  {

    List<NewsModel> getNews();
    Optional<NewsEntity> findById(Long id);
    NewsModel createNews(NewsModel news);


}
