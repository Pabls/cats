package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.domain.interactors.breeds.BreedsInteractor;
import com.ar4i.cats.domain.interactors.images.ImagesInteractor;
import com.ar4i.cats.presentation.breeds.presenter.BreedsPresenter;
import com.ar4i.cats.presentation.main.presenter.MainPresenter;
import com.ar4i.cats.presentation.splash.presenter.SplashPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {
    @Provides
    SplashPresenter provideSplashPresenter(ImagesInteractor imagesInteractor) {
        return new SplashPresenter(imagesInteractor);
    }

    @Provides
    BreedsPresenter provideBreedsPresenter(BreedsInteractor breedsInteractor, ImagesInteractor imagesInteractor){
        return new BreedsPresenter(breedsInteractor, imagesInteractor);
    }

    @Provides
    MainPresenter provideMainPresenter(){
        return new MainPresenter();
    }
}
