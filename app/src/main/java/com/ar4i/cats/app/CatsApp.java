package com.ar4i.cats.app;

import android.app.Application;

import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.app.di.components.DaggerApplicationComponent;
import com.ar4i.cats.app.di.modules.NetworkModule;

public class CatsApp extends Application {
    private static ApplicationComponent applicationComponent;

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createComponent();
    }

    private void createComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .networkModule(new NetworkModule(""))
                .build();
    }
}
