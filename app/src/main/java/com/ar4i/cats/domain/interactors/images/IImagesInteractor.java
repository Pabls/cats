package com.ar4i.cats.domain.interactors.images;

import io.reactivex.Single;

public interface IImagesInteractor {
    Single<String> getRandomImageUrl();
    Single<String> getImageByBreedId(String breedId);
}
