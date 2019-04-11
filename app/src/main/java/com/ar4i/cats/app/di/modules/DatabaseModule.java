package com.ar4i.cats.app.di.modules;

import android.app.Application;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.data.database.DBhelper;
import com.ar4i.cats.data.database.dao.BreedsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    DBhelper provideDbHelper() {
        return new DBhelper(CatsApp.getInstance());
    }

    @Provides
    @Singleton
    BreedsDao provideBreedsDao(DBhelper dBhelper) { return new BreedsDao(dBhelper); }
}
