package com.ar4i.cats.app.di.components;

import com.ar4i.cats.app.di.modules.NetworkModule;
import com.ar4i.cats.app.di.modules.RepositoriesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
        RepositoriesModule.class
})
public interface ApplicationComponent {

}
