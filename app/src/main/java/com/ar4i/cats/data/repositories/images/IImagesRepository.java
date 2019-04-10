package com.ar4i.cats.data.repositories.images;

import io.reactivex.Single;

public interface IImagesRepository {
    Single<String> getRandomImage();
}
