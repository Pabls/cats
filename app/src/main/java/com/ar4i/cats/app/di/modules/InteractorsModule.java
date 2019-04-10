package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.repositories.breeds.BreedsRepository;
import com.ar4i.cats.data.repositories.images.ImagesRepository;
import com.ar4i.cats.domain.interactors.breeds.BreedsInteractor;
import com.ar4i.cats.domain.interactors.images.ImagesInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {
    @Provides
    BreedsInteractor provideBreedsInteractor(BreedsRepository breedsRepository) {
        return new BreedsInteractor(breedsRepository);
    }

    @Provides
    ImagesInteractor provideImagesInteractor(ImagesRepository imagesRepository) {
        return new ImagesInteractor(imagesRepository);
    }
}
