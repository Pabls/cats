package com.ar4i.cats.domain.interactors.images;

import com.ar4i.cats.data.repositories.images.IImagesRepository;

import io.reactivex.Single;

public class ImagesInteractor implements IImagesInteractor {

    public ImagesInteractor(IImagesRepository iImagesRepository) {
        this.iImagesRepository = iImagesRepository;
    }

    // region========================================FIELDS=========================================

    private IImagesRepository iImagesRepository;

    // endregion-------------------------------------FIELDS-----------------------------------------

    // region========================================implements IImagesInteractor===================

    @Override
    public Single<String> getRandomImageUrl() {
        return this.iImagesRepository.getRandomImage();
    }

    @Override
    public Single<String> getImageByBreedId(String breedId) {
        return this.iImagesRepository.getImageByBreedId(breedId);
    }

    // endregion-------------------------------------implements IImagesInteractor-------------------
}
