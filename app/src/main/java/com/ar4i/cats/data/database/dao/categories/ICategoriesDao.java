package com.ar4i.cats.data.database.dao.categories;

import com.ar4i.cats.data.database.dto.CategoryDto;

import java.util.List;

import io.reactivex.Single;

public interface ICategoriesDao {
    Single<List<CategoryDto>> getCategories();
    void insertCategories(List<CategoryDto> entities);
}
