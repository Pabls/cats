package com.ar4i.cats.domain.interactors.categories;

import com.ar4i.cats.data.models.CategoryModel;

import java.util.List;

import io.reactivex.Single;

public interface ICategoriesInteractor {
    Single<List<CategoryModel>> getCategories();
    Single<List<String>> getCategoryNames(List<CategoryModel> categoryModels);
}
