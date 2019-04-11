package com.ar4i.cats.domain.interactors.breeds;

import android.provider.Telephony;

import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.response.Breed;

import java.util.List;

import io.reactivex.Single;

public interface IBreedsInteractor {
    Single<List<PartialBreedModel>> getBreedModels();
    Single<List<String>> getBreedNames(List<PartialBreedModel> models);
    Single<List<Breed>> getBreeds();
    Single<Breed> getBreedByName(String name);
}
