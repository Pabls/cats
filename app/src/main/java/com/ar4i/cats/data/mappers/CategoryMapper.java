package com.ar4i.cats.data.mappers;

import com.ar4i.cats.data.database.dto.CategoryDto;
import com.ar4i.cats.data.models.CategoryModel;
import com.ar4i.cats.data.network.response.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper implements IVmMapper<CategoryModel, Category, CategoryDto> {

    @Override
    public List<CategoryModel> mapToViewModel(List<Category> data) {
        List<CategoryModel> models = new ArrayList<>();
        if (data != null && !data.isEmpty()) {
            for (Category category : data) {
                models.add(new CategoryModel(category.getId(), category.getName()));
            }
        }
        return models;
    }

    @Override
    public List<CategoryDto> mapToDbEntity(List<Category> data) {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        if (data != null && !data.isEmpty()) {
            for (Category category : data) {
                categoryDtos.add(new CategoryDto(category.getId(), category.getName()));
            }
        }
        return categoryDtos;
    }
}
