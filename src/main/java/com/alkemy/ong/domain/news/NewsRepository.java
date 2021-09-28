package com.alkemy.ong.domain.news;


import java.util.List;
import java.util.Optional;

public interface NewsRepository  {
    List<NewsModel> getNews();
    Optional<NewsModel> findById(Long id);
    NewsModel createNews(NewsModel news);
    NewsModel updateNews(NewsModel news);
    void delete(NewsModel news);
}
