package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.categories.CategoriesModel;
import com.alkemy.ong.domain.categories.CategoriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    private CategoriesService categoriesService;

    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public List<CategoriesModel> findAll() {
        return categoriesService.getCategories();
    }
}