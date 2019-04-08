package com.ar4i.cats.domain.interactors;

import com.ar4i.cats.data.repositories.breeds.IBreedsRepository;
import com.ar4i.cats.domain.mappers.IMapper;
import com.ar4i.cats.domain.models.BreedModel;

import java.util.List;

import io.reactivex.Single;

public class BreedsInteractor implements IBreedsInteractor {

    //==========================================start Fields========================================

    IMapper iMapper;
    IBreedsRepository iBreedsRepository;

    //-------------------------------------------end -Fields----------------------------------------

    public BreedsInteractor(IMapper iMapper, IBreedsRepository iBreedsRepository) {
        this.iMapper = iMapper;
        this.iBreedsRepository = iBreedsRepository;
    }

    //==========================================start Public methods================================

    @Override
    public Single<List<BreedModel>> getBreedNames() {
        return iBreedsRepository.getBreeds().map(breeds -> iMapper.mapToViewModel(breeds));
    }

    //-------------------------------------------end Public methods---------------------------------
}
