package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.news.NewsModel;
import com.alkemy.ong.domain.news.NewsRepository;
import com.alkemy.ong.domain.news.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<NewsModel> findNews(){
        return newsService.getNews();
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> news2(@PathVariable Integer id){
        return new ResponseEntity<>(newsRepository.findById(id), HttpStatus.ACCEPTED);
    }*/

}
