package com.alkemy.ong.domain.categories;

import jdk.jfr.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DefaultCategoriesService implements CategoriesService {

    CategoriesRepository categoriesRepository;

    public DefaultCategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public List<CategoriesModel> getCategories() {
        return categoriesRepository.getCategories();
    }

    @Override
    public CategoriesModel postCategory(CategoriesModel category) {
        return categoriesRepository.postCategories(category);
    }
}