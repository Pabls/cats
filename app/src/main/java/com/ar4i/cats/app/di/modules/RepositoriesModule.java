package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.repositories.CategoriesRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    public CategoriesRepository provideCategoriesRepository(Api api) {
        return new CategoriesRepository(api);
    }

}
