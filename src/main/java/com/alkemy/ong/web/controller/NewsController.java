package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.news.NewsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    NewsRepository newsRepository;

    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/news")
    public ResponseEntity<?> news(){
        return new ResponseEntity<>(newsRepository.findAll(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> news2(@PathVariable Integer id){
        return new ResponseEntity<>(newsRepository.findById(id), HttpStatus.ACCEPTED);
    }

}
