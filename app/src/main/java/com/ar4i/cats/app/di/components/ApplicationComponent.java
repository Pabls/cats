package com.ar4i.cats.app.di.components;

import com.ar4i.cats.app.CatsApp;
import com.ar4i.cats.app.di.modules.ApplicationModule;
import com.ar4i.cats.app.di.modules.DatabaseModule;
import com.ar4i.cats.app.di.modules.InteractorsModule;
import com.ar4i.cats.app.di.modules.MappersModule;
import com.ar4i.cats.app.di.modules.NetworkModule;
import com.ar4i.cats.app.di.modules.PresentationModule;
import com.ar4i.cats.app.di.modules.RepositoriesModule;
import com.ar4i.cats.presentation.breeds.view.BreedsFragment;
import com.ar4i.cats.presentation.categories.view.CategoriesFragment;
import com.ar4i.cats.presentation.main.view.MainActivity;
import com.ar4i.cats.presentation.splash.view.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        DatabaseModule.class,
        InteractorsModule.class,
        MappersModule.class,
        NetworkModule.class,
        PresentationModule.class,
        RepositoriesModule.class,
})
public interface ApplicationComponent {

    CatsApp application();

    // Activities
    void inject(SplashActivity activity);
    void inject(MainActivity mainActivity);

    // Fragments
    void inject(BreedsFragment breedsFragment);
    void inject(CategoriesFragment categoriesFragment);
}
