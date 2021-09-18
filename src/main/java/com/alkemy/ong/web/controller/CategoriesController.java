package com.alkemy.ong.web.controller;

import com.alkemy.ong.domain.categories.CategoriesModel;
import com.alkemy.ong.domain.categories.CategoriesService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<CategoriesModel> createCategory(@RequestBody CategoriesModel category){
        categoriesService.createCategory(category);
        return new ResponseEntity<CategoriesModel>(category, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriesModel> updateCategories(@RequestBody CategoriesModel categoriesModel, @PathVariable(value = "id") Long categoriesId) {
        return ResponseEntity.ok(categoriesService.updateCategories(categoriesModel, categoriesId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategories(@PathVariable (value = "id") Long categoriesId) {
        categoriesService.deleteCategories(categoriesId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}