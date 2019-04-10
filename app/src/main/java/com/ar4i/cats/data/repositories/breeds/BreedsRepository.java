package com.ar4i.cats.data.repositories.breeds;

import com.ar4i.cats.data.mappers.IMapper;
import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.response.Breed;

import java.util.List;

import io.reactivex.Single;

public class BreedsRepository implements IBreedsRepository {

    public BreedsRepository(Api api, IMapper iMapper) {
        this.api = api;
        this.iMapper = iMapper;
    }

    //==========================================start FIELDS========================================

    private Api api;
    private IMapper iMapper;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements IBreedsRepository==================

    @Override
    public Single<List<PartialBreedModel>> getBreedNames() {
        return this.api.getBreeds().map(breeds -> iMapper.mapToViewModel(breeds));
    }

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
