package com.ar4i.cats.data.repositories.categories;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.response.Category;

import java.util.List;

import io.reactivex.Single;

public class CategoriesRepository implements ICategoriesRepository {

    public CategoriesRepository(Api api) { this.api = api; }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements ICategoriesRepository==============

    @Override
    public Single<List<Category>> getCategories() {
        return api.getCategories();
    }

    //-------------------------------------------end implements ICategoriesRepository---------------

}
