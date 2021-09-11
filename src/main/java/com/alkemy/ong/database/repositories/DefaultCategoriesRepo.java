package com.alkemy.ong.database.repositories;

import com.alkemy.ong.database.entities.CategoriesEntity;
import com.alkemy.ong.database.jparepositories.CategoriesJpaRepo;
import com.alkemy.ong.domain.categories.CategoriesModel;
import com.alkemy.ong.domain.categories.CategoriesRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DefaultCategoriesRepo implements CategoriesRepository {

    private CategoriesJpaRepo categoriesJPARepo;

    public DefaultCategoriesRepo(CategoriesJpaRepo categoriesJPARepo) {
        this.categoriesJPARepo = categoriesJPARepo;
    }

    @Override
    public List<CategoriesModel> getCategories() {
        CategoriesModel categoriesModel = new CategoriesModel();
        List<CategoriesModel> categories = new ArrayList<>();
        for (CategoriesEntity ce : categoriesJPARepo.findAll()) {

            categoriesModel.setName(ce.getName());
            categoriesModel.setDescription(ce.getDescription());
            categoriesModel.setImage(ce.getImage());
            categoriesModel.setCreatedAt(ce.getCreatedAt());
            categoriesModel.setUpdatedAt(ce.getUpdatedAt());

            categories.add(categoriesModel);
        }
        return categories;
    }

    @Override
    public CategoriesModel postCategories(CategoriesModel categories) {
        categoriesJPARepo.save(this.toEntity(categories));
        return categories;
    }

    private CategoriesEntity toEntity(CategoriesModel cm) {
        CategoriesEntity categoriesEntity = new CategoriesEntity();
        categoriesEntity.setName(cm.getName());
        categoriesEntity.setDescription(cm.getDescription());
        categoriesEntity.setImage(cm.getImage());
        return categoriesEntity;
    }
}
