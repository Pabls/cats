package com.ar4i.cats.domain.interactors.images;

import java.util.List;

import io.reactivex.Single;

public interface IImagesInteractor {
    Single<String> getRandomImageUrl();
    Single<String> getImageByBreedId(String breedId);
    Single<List<String>> getImagesByCategory(int categoryId);
}
