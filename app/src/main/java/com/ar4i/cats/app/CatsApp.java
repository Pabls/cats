package com.ar4i.cats.app;

import android.app.Application;
import android.net.ConnectivityManager;
import android.util.Log;
import android.widget.Toast;

import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.app.di.components.DaggerApplicationComponent;
import com.ar4i.cats.app.di.modules.ApplicationModule;
import com.facebook.stetho.Stetho;

import io.reactivex.plugins.RxJavaPlugins;

public class CatsApp extends Application {

    // region========================================Fields=========================================

    private static ApplicationComponent APPLICATION_COMPONENT;
    private static ConnectivityManager CONNECTIVITY_MANAGER;

    // endregion-------------------------------------Fields-----------------------------------------


    // region========================================Public Methods=================================

    public static ApplicationComponent getApplicationComponent() {
        return APPLICATION_COMPONENT;
    }

    public static ConnectivityManager getService() { return CONNECTIVITY_MANAGER; }

    // endregion-------------------------------------Public Methods---------------------------------


    // region========================================Lifecycle======================================

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        getConnectivityManager();
        createComponent();
    }

    // endregion-------------------------------------Lifecycle--------------------------------------


    // region========================================Private Methods================================

    private void initStetho() {
        Stetho.InitializerBuilder initializerBuilder =
                Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);
    }

    private void createComponent() {
        APPLICATION_COMPONENT = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    private void getConnectivityManager() {
        this.CONNECTIVITY_MANAGER = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    }

    // endregion-------------------------------------Private Methods--------------------------------

}
