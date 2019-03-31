package com.ar4i.cats.domain.mappers;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.domain.models.ShortenedBreedModel;

import java.util.ArrayList;
import java.util.List;

public class BreedMapper implements IMapper<ShortenedBreedModel, Breed> {

    @Override
    public List<ShortenedBreedModel> mapToViewModel(List<Breed> data) {
        List<ShortenedBreedModel> viewModels = new ArrayList<>();
        return viewModels;
    }

}
