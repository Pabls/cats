package com.ar4i.cats.data.database.dao;

import com.ar4i.cats.data.database.dto.BreedDto;

import java.util.List;

import io.reactivex.Single;

public interface IBreedsDao {
    Single<List<BreedDto>> getBreeds();
    void insertBreeds(List<BreedDto> entities);
}
