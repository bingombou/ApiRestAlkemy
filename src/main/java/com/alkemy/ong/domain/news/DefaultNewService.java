package com.alkemy.ong.domain.news;

import com.alkemy.ong.database.entities.NewsEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultNewService implements NewsService {
    private NewsRepository newsRepository;

    public DefaultNewService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsModel> getNews() {
        return newsRepository.findAll();
    }

    @Override
    public NewsEntity createNews(NewsEntity newsEntity) {
        return null;
    }

    @Override
    public NewsEntity getNewsById(int id) {
        return null;
    }

    @Override
    public NewsEntity updateNews(NewsEntity newsEntity) {
        return null;
    }

    @Override
    public void deleteNews(int id) {

    }
}
