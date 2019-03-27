package com.ar4i.cats.app;

import android.app.Application;

import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.app.di.components.DaggerApplicationComponent;
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

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    private void initStetho() {

        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);

        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));

        Stetho.Initializer initializer = initializerBuilder.build();

        Stetho.initialize(initializer);
    }

    private void createComponent() {
        applicationComponent = DaggerApplicationComponent.builder().build();
    }
}
