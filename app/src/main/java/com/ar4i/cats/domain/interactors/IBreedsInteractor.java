package com.ar4i.cats.domain.interactors;

import com.ar4i.cats.domain.models.BreedModel;

import java.util.List;

import io.reactivex.Single;

public interface IBreedsInteractor {
    Single<List<BreedModel>> getBreedNames();
}
