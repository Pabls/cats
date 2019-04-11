package com.ar4i.cats.data.mappers;

import com.ar4i.cats.data.database.entities.BreedEntity;
import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.response.Breed;

import java.util.ArrayList;
import java.util.List;

public class BreedMapper implements IVmMapper<PartialBreedModel, Breed, BreedEntity> {

    @Override
    public List<PartialBreedModel> mapToViewModel(List<Breed> breeds) {
        List<PartialBreedModel> viewModels = new ArrayList<>();
        if (breeds != null && !breeds.isEmpty()) {
            for (Breed breed : breeds) {
                viewModels.add(new PartialBreedModel(breed.getId(), breed.getName()));
            }
        }
        return viewModels;
    }

    @Override
    public List<BreedEntity> mapToDbEntity(List<Breed> breeds) {
        List<BreedEntity> breedEntities = new ArrayList<>();
        if (breeds != null && !breeds.isEmpty()) {
            for (Breed breed : breeds) {
                breedEntities.add(new BreedEntity(breed.getId(), breed.getName()));
            }
        }
        return breedEntities;
    }

}
