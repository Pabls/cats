package com.ar4i.cats.domain.interactors;

import com.ar4i.cats.data.repositories.breeds.IBreedsRepository;
import com.ar4i.cats.domain.mappers.IMapper;
import com.ar4i.cats.domain.models.ShortenedBreedModel;

import java.util.List;

import io.reactivex.Single;

public class BreedsInteractor {

    //==========================================start Fields========================================

    IMapper iMapper;
    IBreedsRepository iBreedsRepository;

    //-------------------------------------------end -Fields----------------------------------------

    public BreedsInteractor(IMapper iMapper, IBreedsRepository iBreedsRepository) {
        this.iMapper = iMapper;
        this.iBreedsRepository = iBreedsRepository;
    }

    //==========================================start Public methods================================

    Single<List<ShortenedBreedModel>> getBreedNames() {
        return iBreedsRepository.getBreeds().map(breeds -> iMapper.mapToViewModel(breeds));
    }

    //-------------------------------------------end Public methods---------------------------------
}
