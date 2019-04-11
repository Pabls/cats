package com.ar4i.cats.domain.interactors.breeds;

import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.data.repositories.breeds.IBreedsRepository;

import java.util.ArrayList;
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
    public Single<List<PartialBreedModel>> getBreedModels() {
        return this.iBreedsRepository.getBreedNames();
    }

    @Override
    public Single<List<String>> getBreedNames(List<PartialBreedModel> models) {
        return Single.create(emitter -> {
            List<String> names = new ArrayList<>();
            if(!models.isEmpty()){
                for(PartialBreedModel breedModel: models){
                    names.add(breedModel.getName());
                }
            }
            emitter.onSuccess(names);
        });
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
