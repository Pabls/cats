package com.ar4i.cats.data.repositories.categories;

import com.ar4i.cats.data.mappers.IVmMapper;
import com.ar4i.cats.data.models.CategoryModel;
import com.ar4i.cats.data.network.Api;

import java.util.List;

import io.reactivex.Single;

public class CategoriesRepository implements ICategoriesRepository {

    public CategoriesRepository(Api api, IVmMapper iVmMapper) {
        this.api = api;
        this.iVmMapper = iVmMapper;
    }

    //==========================================start FIELDS========================================

    private Api api;
    private IVmMapper iVmMapper;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements ICategoriesRepository==============

    @Override
    public Single<List<CategoryModel>> getCategories() {
        return api.getCategories().map(categories -> iVmMapper.mapToViewModel(categories));
    }

    //-------------------------------------------end implements ICategoriesRepository---------------

}
