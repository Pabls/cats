package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.data.database.DBhelper;
import com.ar4i.cats.data.database.dao.breeds.BreedsDao;
import com.ar4i.cats.data.database.dao.categories.CategoriesDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DBhelper provideDbHelper(CatsApp application) {
        return new DBhelper(application);
    }

    @Provides
    @Singleton
    BreedsDao provideBreedsDao(DBhelper dBhelper) { return new BreedsDao(dBhelper); }

    @Provides
    @Singleton
    CategoriesDao provideCategoriesDao(DBhelper dBhelper) { return new CategoriesDao(dBhelper); }
}
