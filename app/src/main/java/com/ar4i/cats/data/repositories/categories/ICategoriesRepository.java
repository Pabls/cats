package com.ar4i.cats.data.repositories.categories;

import com.ar4i.cats.data.network.response.Category;

import java.util.List;

import io.reactivex.Single;

public interface ICategoriesRepository {
    Single<List<Category>> getCategories();
}
