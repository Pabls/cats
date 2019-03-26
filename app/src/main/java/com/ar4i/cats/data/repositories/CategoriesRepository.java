package com.ar4i.cats.data.repositories;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.response.Category;

import java.util.List;

import io.reactivex.Single;

public class CategoriesRepository {

    private Api api;

    public CategoriesRepository(Api api){
        this.api = api;
    }

    public Single<List<Category>> getCategories(){
        return api.getCategories();
    }
}
