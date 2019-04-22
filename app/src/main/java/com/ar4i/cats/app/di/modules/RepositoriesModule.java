package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.data.database.dao.BreedsDao;
import com.ar4i.cats.data.mappers.BreedMapper;
import com.ar4i.cats.data.mappers.CategoryMapper;
import com.ar4i.cats.data.mappers.ImageMapper;
import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.repositories.breeds.BreedsRepository;
import com.ar4i.cats.data.repositories.categories.CategoriesRepository;
import com.ar4i.cats.data.repositories.favorites.FavoritesRepository;
import com.ar4i.cats.data.repositories.images.ImagesRepository;
import com.ar4i.cats.data.repositories.system.SystemRepository;
import com.ar4i.cats.data.repositories.votes.VotesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    public BreedsRepository provideBreedsRepository(Api api, BreedMapper breedMapper, BreedsDao breedsDao) {
        return new BreedsRepository(api, breedMapper, breedsDao);
    }

    @Provides
    public CategoriesRepository provideCategoriesRepository(Api api, CategoryMapper categoryMapper) {
        return new CategoriesRepository(api, categoryMapper); }

    @Provides
    public FavoritesRepository provideFavoritesRepository(Api api) { return new FavoritesRepository(api); }

    @Provides
    public ImagesRepository provideImagesRepository(Api api, ImageMapper imageMapper) {
        return new ImagesRepository(api, imageMapper);
    }

    @Provides
    public SystemRepository provideSystemRepository(CatsApp application) { return new SystemRepository(application); }

    @Provides
    public VotesRepository provideVotesRepository(Api api) {
        return new VotesRepository(api);
    }
}
