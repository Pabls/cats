package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.repositories.breeds.BreedsRepository;
import com.ar4i.cats.data.repositories.categories.CategoriesRepository;
import com.ar4i.cats.data.repositories.images.ImagesRepository;
import com.ar4i.cats.data.repositories.system.SystemRepository;
import com.ar4i.cats.domain.interactors.breeds.BreedsInteractor;
import com.ar4i.cats.domain.interactors.categories.CategoriesInteractor;
import com.ar4i.cats.domain.interactors.images.ImagesInteractor;
import com.ar4i.cats.domain.interactors.system.SystemInteractor;

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

    @Provides
    CategoriesInteractor provideCategoriesInteractor(CategoriesRepository categoriesRepository){
        return new CategoriesInteractor(categoriesRepository);
    }

    @Provides
    SystemInteractor provideSystemInteractor(SystemRepository systemRepository){
        return new SystemInteractor(systemRepository);
    }
}
