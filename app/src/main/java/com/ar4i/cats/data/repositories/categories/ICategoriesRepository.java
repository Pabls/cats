package com.ar4i.cats.data.repositories.categories;

import com.ar4i.cats.data.models.CategoryModel;

import java.util.List;

import io.reactivex.Single;

public interface ICategoriesRepository {
    Single<List<CategoryModel>> getCategories();
}
