package com.ar4i.cats.data.repositories.images;

import java.util.List;

import io.reactivex.Single;

public interface IImagesRepository {
    Single<String> getRandomImage();
    Single<String> getImageByBreedId(String breedId);
    Single<List<String>> getImagesByCategory(int categoryId);
}
