package com.ar4i.cats.data.mappers;

import com.ar4i.cats.data.models.PartialBreedModel;
import com.ar4i.cats.data.network.response.Breed;

import java.util.ArrayList;
import java.util.List;

public class BreedMapper implements IVmMapper<PartialBreedModel, Breed> {

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

}
