package com.ar4i.cats.app.di.components;

import com.ar4i.cats.app.di.modules.NetworkModule;
import com.ar4i.cats.app.di.modules.PresentationModule;
import com.ar4i.cats.app.di.modules.RepositoriesModule;
import com.ar4i.cats.presentation.splash.view.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        PresentationModule.class,
        RepositoriesModule.class,
})
public interface ApplicationComponent {
    void inject(SplashActivity activity);
}
