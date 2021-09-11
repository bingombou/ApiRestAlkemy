package com.alkemy.ong.domain.categories;

import java.util.List;

public interface CategoriesService {

    List<CategoriesModel> getCategories();
    CategoriesModel postCategory(CategoriesModel category);

}