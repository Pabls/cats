package com.ar4i.cats.app;

import android.app.Application;

import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.app.di.components.DaggerApplicationComponent;
import com.ar4i.cats.app.di.modules.NetworkModule;
import com.ar4i.cats.app.di.modules.PresentationModule;
import com.ar4i.cats.app.di.modules.RepositoriesModule;
import com.facebook.stetho.Stetho;

public class CatsApp extends Application {
    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        createComponent();
    }

    private void initStetho(){
        // Create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(
                Stetho.defaultInspectorModulesProvider(this)
        );

        // Enable command line interface
        initializerBuilder.enableDumpapp(
                Stetho.defaultDumperPluginsProvider(this)
        );

        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();

        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }

    private void createComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule())
                .presentationModule(new PresentationModule())
                .repositoriesModule(new RepositoriesModule())
                .build();
    }
}
