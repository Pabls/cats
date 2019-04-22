package com.ar4i.cats.data.repositories.system;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import com.ar4i.cats.app.CatsApp;

import io.reactivex.Single;

public class SystemRepository implements ISystemRepository {

    public SystemRepository(CatsApp app) {
        this.app = app;
    }
    // region========================================Fields=========================================

    private CatsApp app;

    // endregion-------------------------------------Fields-----------------------------------------

    // region========================================Public Methods=================================

    @Override
    public Single<Boolean> hasNetworkConnection() {
        return Single.create(emitter -> emitter.onSuccess(hasConnection()));
    }

    @Override
    public Single<Boolean> hasPermissions() {
        return Single.create(emitter -> {
            boolean res = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                res = hasPermissions(app.checkSelfPermission(Manifest.permission.CAMERA)) &&
                      hasPermissions(app.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) &&
                      hasPermissions(app.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE));
            }
            emitter.onSuccess(res);
        });
    }

    @Override
    public Single<Boolean> hasExternalStoragePermissions() {
        return Single.create(emitter -> {
            boolean res = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                res = hasPermissions(app.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)) &&
                      hasPermissions(app.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE));
            }
            emitter.onSuccess(res);
        });
    }

    @Override
    public Single<Boolean> hasCameraPermissions() {
        return Single.create(emitter -> {
            boolean res = true;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                res = hasPermissions(app.checkSelfPermission(Manifest.permission.CAMERA));
            }
            emitter.onSuccess(res);
        });
    }

    // endregion-------------------------------------Public Methods---------------------------------


    // region========================================Private Methods================================

    private boolean hasPermissions(int permissions) {
        return permissions == PackageManager.PERMISSION_GRANTED;
    }

    private boolean hasConnection() {
        boolean res = false;
        final ConnectivityManager cm = CatsApp.getService();
        if (cm != null) {
            final NetworkInfo ni = cm.getActiveNetworkInfo();
            res = ni != null && ni.isConnected();
        }
        return res;
    }

    // endregion-------------------------------------Private Methods--------------------------------
}
