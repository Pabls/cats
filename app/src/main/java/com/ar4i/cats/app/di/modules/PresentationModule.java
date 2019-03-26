package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.repositories.CategoriesRepository;
import com.ar4i.cats.presentation.splash.presenter.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {
    @Provides
    SplashPresenter provideSplashPresenter(CategoriesRepository categoriesRepository) {
        return new SplashPresenter(categoriesRepository);
    }
}
