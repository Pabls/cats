package com.ar4i.cats.data.database.dao;

import com.ar4i.cats.data.database.entities.BreedEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface IBreedsDao {
    Single<List<BreedEntity>> getBreeds();
    Completable insertBreeds(List<BreedEntity> entities);
}
