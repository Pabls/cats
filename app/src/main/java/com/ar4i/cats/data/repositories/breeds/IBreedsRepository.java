package com.ar4i.cats.data.repositories.breeds;

import com.ar4i.cats.data.network.response.Breed;

import java.util.List;

import io.reactivex.Single;

public interface IBreedsRepository {
    Single<List<Breed>> getBreeds();
    Single<List<Breed>> getBreedsByName(String name);
}
