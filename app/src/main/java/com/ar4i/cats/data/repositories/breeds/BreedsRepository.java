package com.ar4i.cats.data.repositories.breeds;

import com.ar4i.cats.data.database.dao.breeds.IBreedsDao;
import com.ar4i.cats.data.database.dto.BreedDto;
import com.ar4i.cats.data.mappers.IVmMapper;
import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.response.Breed;

import java.util.List;

import io.reactivex.Single;

public class BreedsRepository implements IBreedsRepository {

    public BreedsRepository(Api api, IVmMapper iMapper, IBreedsDao breedsDao) {
        this.api = api;
        this.iMapper = iMapper;
        this.breedsDao = breedsDao;
    }

    //==========================================start FIELDS========================================

    private Api api;
    private IVmMapper iMapper;
    private IBreedsDao breedsDao;

    //-------------------------------------------end FIELDS-----------------------------------------

    //==========================================start implements IBreedsRepository==================

    @Override
    public Single<List<PartialBreedModel>> getBreedNames() {
        return this.api.getBreeds()
                .doOnSuccess(breeds -> {
                    List<BreedDto> breedEntities = this.iMapper.mapToDbEntity(breeds);
                    this.breedsDao.insertBreeds(breedEntities);
                }).map(breeds -> this.iMapper.mapToViewModel(breeds));
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
