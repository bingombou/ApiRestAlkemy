package com.alkemy.ong.domain.news;


import com.alkemy.ong.database.entities.NewsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface NewsService {

    public List<NewsEntity> getNews();
    public NewsEntity createNews(NewsEntity newsEntity);
    public NewsEntity getNewsById(int id);
    public NewsEntity updateNews(NewsEntity newsEntity);
    public void deleteNews(int id);
}
