package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.repositories.breeds.BreedsRepository;
import com.ar4i.cats.data.repositories.breeds.IBreedsRepository;
import com.ar4i.cats.data.repositories.categories.CategoriesRepository;
import com.ar4i.cats.data.repositories.categories.ICategoriesRepository;
import com.ar4i.cats.data.repositories.favorites.FavoritesRepository;
import com.ar4i.cats.data.repositories.favorites.IFavoritesRepository;
import com.ar4i.cats.data.repositories.images.IImagesRepository;
import com.ar4i.cats.data.repositories.images.ImagesRepository;
import com.ar4i.cats.data.repositories.system.ISystemRepository;
import com.ar4i.cats.data.repositories.system.SystemRepository;
import com.ar4i.cats.data.repositories.votes.IVotesRepository;
import com.ar4i.cats.data.repositories.votes.VotesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    public IBreedsRepository provideBreedsRepository(Api api) {
        return new BreedsRepository(api);
    }

    @Provides
    public ICategoriesRepository provideCategoriesRepository(Api api) { return new CategoriesRepository(api); }

    @Provides
    public IFavoritesRepository provideFavoritesRepository(Api api) { return new FavoritesRepository(api); }

    @Provides
    public IImagesRepository provideImagesRepository(Api api) {
        return new ImagesRepository(api);
    }

    @Provides
    public ISystemRepository provideSystemRepository() { return new SystemRepository(); }

    @Provides
    public IVotesRepository provideVotesRepository(Api api) {
        return new VotesRepository(api);
    }
}
