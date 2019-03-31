package com.ar4i.cats.data.repositories.breeds;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.response.Breed;

import java.util.List;

import io.reactivex.Single;

public class BreedsRepository implements IBreedsRepository {

    public BreedsRepository(Api api) {
        this.api = api;
    }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements IBreedsRepository==================

    @Override
    public Single<List<Breed>> getBreeds() {
        return api.getBreeds();
    }

    @Override
    public Single<List<Breed>> getBreedsByName(String name) {
        return api.getBreedsByName(name);
    }

    //-------------------------------------------end implements IBreedsRepository-------------------


}
