package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.app.CatsApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private CatsApp application;

    public ApplicationModule(CatsApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    CatsApp provideApplication() {
        return application;
    }

}
