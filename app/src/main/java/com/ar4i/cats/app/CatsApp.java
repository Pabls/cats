package com.ar4i.cats.app;

import android.app.Application;
import android.net.ConnectivityManager;

import com.ar4i.cats.app.di.components.ApplicationComponent;
import com.ar4i.cats.app.di.components.DaggerApplicationComponent;
import com.ar4i.cats.data.database.CatsDB;
import com.facebook.stetho.Stetho;

import androidx.room.Room;

public class CatsApp extends Application {

    // region========================================Fields=========================================

    private static CatsApp INSTANCE;
    private static ApplicationComponent APPLICATION_COMPONENT;
    private static ConnectivityManager CONNECTIVITY_MANAGER;
    private static CatsDB DATABASE;

    // endregion-------------------------------------Fields-----------------------------------------


    // region========================================Public Methods=================================

    public static CatsApp getInstance() { return INSTANCE; }

    public static ApplicationComponent getApplicationComponent() {
        return APPLICATION_COMPONENT;
    }

    public static ConnectivityManager getService() { return CONNECTIVITY_MANAGER; }

    public static CatsDB getDatabase() { return DATABASE; }

    // endregion-------------------------------------Public Methods---------------------------------


    // region========================================Lifecycle======================================

    @Override
    public void onCreate() {
        super.onCreate();
        initStetho();
        getConnectivityManager();
        initDatabase();
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
        APPLICATION_COMPONENT = DaggerApplicationComponent.builder().build();
    }

    private void getConnectivityManager() {
        this.CONNECTIVITY_MANAGER = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
    }

    private void initDatabase(){
        this.DATABASE  = Room.databaseBuilder(this, CatsDB.class, CatsDB.DATABASE_NAME).build();
    }
    // endregion-------------------------------------Private Methods--------------------------------

}
