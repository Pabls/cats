package com.ar4i.cats.domain.interactors.categories;

import com.ar4i.cats.data.models.CategoryModel;
import com.ar4i.cats.data.repositories.categories.ICategoriesRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class CategoriesInteractor implements ICategoriesInteractor {

    public CategoriesInteractor(ICategoriesRepository iCategoriesRepository) {
        this.iCategoriesRepository = iCategoriesRepository;
    }

    // region========================================Fields=========================================

    private ICategoriesRepository iCategoriesRepository;

    // endregion-------------------------------------Fields-----------------------------------------

    @Override
    public Single<List<CategoryModel>> getCategories() {
        return iCategoriesRepository.getCategories();
    }

    @Override
    public Single<List<String>> getCategoryNames(List<CategoryModel> categoryModels) {
        return Single.create(emitter -> {
            List<String> names = new ArrayList<>();
            if (categoryModels != null) {
                for (CategoryModel categoryModel : categoryModels) {
                    names.add(categoryModel.getName());
                }
            }
            emitter.onSuccess(names);
        });
    }
}
