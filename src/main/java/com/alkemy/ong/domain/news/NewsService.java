package com.alkemy.ong.domain.news;

import java.util.List;

public interface NewsService {
     List<NewsModel> getNews();
     NewsModel createNews (NewsModel news);
     NewsModel getNewsById(Long id);
     NewsModel updateNews(NewsModel news);
     void deleteNews(Long id);
}
