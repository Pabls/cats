package com.ar4i.cats.domain.mappers;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.domain.models.BreedModel;

import java.util.ArrayList;
import java.util.List;

public class BreedMapper implements IMapper<BreedModel, Breed> {

    @Override
    public List<BreedModel> mapToViewModel(List<Breed> data) {
        List<BreedModel> viewModels = new ArrayList<>();
        return viewModels;
    }

}
