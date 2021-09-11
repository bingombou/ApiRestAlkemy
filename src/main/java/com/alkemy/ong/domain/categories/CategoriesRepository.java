package com.alkemy.ong.domain.categories;

import java.util.List;

public interface CategoriesRepository {

    List<CategoriesModel> getCategories();

    CategoriesModel postCategories(CategoriesModel categories);
}