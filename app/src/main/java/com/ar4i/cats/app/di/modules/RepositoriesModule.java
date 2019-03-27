package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.repositories.breeds.BreedsRepository;
import com.ar4i.cats.data.repositories.categories.CategoriesRepository;
import com.ar4i.cats.data.repositories.favorites.FavoritesRepository;
import com.ar4i.cats.data.repositories.images.ImagesRepository;
import com.ar4i.cats.data.repositories.votes.VotesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    public BreedsRepository provideBreedsRepository(Api api) {
        return new BreedsRepository(api);
    }

    @Provides
    public CategoriesRepository provideCategoriesRepository(Api api) { return new CategoriesRepository(api); }

    @Provides
    public FavoritesRepository provideFavoritesRepository(Api api) { return new FavoritesRepository(api); }

    @Provides
    public ImagesRepository provideImagesRepository(Api api) {
        return new ImagesRepository(api);
    }

    @Provides
    public VotesRepository provideVotesRepository(Api api) {
        return new VotesRepository(api);
    }
}
