package com.alkemy.ong.web.controller;


import com.alkemy.ong.domain.news.NewsModel;
import com.alkemy.ong.domain.news.NewsService;
import com.alkemy.ong.web.dto.NewsDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "news")
public class NewsController {

    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public ResponseEntity<List<NewsDto>> getNews(){
        List<NewsDto> result = newsService.getNews().stream().map(m -> toDto(m)).collect(Collectors.toList());
            return new ResponseEntity<List<NewsDto>>(result, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<NewsDto> createNews(@Valid @RequestBody NewsDto news) {
        return new ResponseEntity<NewsDto>(this.toDto(newsService.createNews(toModel(news))), HttpStatus.CREATED);
    }

        private NewsDto toDto(NewsModel news){
            return new NewsDto(news.getId(), news.getName(), news.getImage(), news.getContent(),
                    news.isDeleted(), news.getCreatedAt(),news.getUpdatedAt());
        }

        private NewsModel toModel(NewsDto mm){
            NewsModel news = new NewsModel();
            news.setId(mm.getId());
            news.setName(mm.getName());
            news.setContent(mm.getContent());
            news.setImage(mm.getImage());
            news.setDeleted(mm.isDeleted());
            news.setCreatedAt(mm.getCreatedAt());
            news.setUpdatedAt(mm.getUpdatedAt());

            return news;
        }

        @PutMapping(path = "{news.getId()}")
        public ResponseEntity<NewsDto> updateNews(@Valid @RequestBody NewsModel news){
            newsService.updateNews(news);

            NewsDto newsDto = new NewsDto(news.getId(), news.getName(), news.getContent(),
                    news.getImage(), news.getCreatedAt(), news.getUpdatedAt());

            return new ResponseEntity<NewsDto>(newsDto, HttpStatus.OK);
        }

}
