package com.alkemy.ong.domain.news;

import com.alkemy.ong.database.entities.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface NewsRepository  {

    public List<NewsModel> findAll();
    public NewsModel findById(int id);

}
