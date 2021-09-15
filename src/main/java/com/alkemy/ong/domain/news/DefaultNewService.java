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

    public List<NewsModel> getNews() {
        return newsRepository.getNews();
    }


    public NewsModel createNews(NewsModel news) {
        return newsRepository.createNews(news);
    }
    private NewsModel toModel(NewsEntity mm){
        NewsModel news = new NewsModel();
        news.setId(mm.getId());
        news.setName(mm.getName());
        news.setCreatedAt(mm.getCreatedAt());
        news.setDeleted(mm.isDeleted());
        news.setContent(mm.getContent());
        news.setImage(mm.getImage());
        news.setUpdatedAt(mm.getUpdatedAt());
        return news;
    }

    @Override
    public NewsModel getNewsById(Long id) {
        return null;
    }

    @Override
    public NewsModel updateNews(NewsModel news) {
        return null;
    }

    @Override
    public void deleteNews(Long id) {

    }
}
