package com.ar4i.cats.domain.interactors.breeds;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.data.repositories.breeds.IBreedsRepository;
import com.ar4i.cats.data.models.PartialBreedModel;

import java.util.List;

import io.reactivex.Single;

public class BreedsInteractor implements IBreedsInteractor {

    //==========================================start Fields========================================

    IBreedsRepository iBreedsRepository;

    //-------------------------------------------end -Fields----------------------------------------

    public BreedsInteractor( IBreedsRepository iBreedsRepository) {
        this.iBreedsRepository = iBreedsRepository;
    }

    //==========================================start Public methods================================

    @Override
    public Single<List<PartialBreedModel>> getBreedNames() {
        return this.iBreedsRepository.getBreedNames();
    }

    @Override
    public Single<List<Breed>> getBreeds() {
        return this.iBreedsRepository.getBreeds();
    }

    @Override
    public Single<Breed> getBreedByName(String name) {
        return this.iBreedsRepository.getBreedsByName(name).map(breeds -> breeds.get(0));
    }

    //-------------------------------------------end Public methods---------------------------------
}
