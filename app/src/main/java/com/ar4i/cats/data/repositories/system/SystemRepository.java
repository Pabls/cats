package com.ar4i.cats.data.repositories.system;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import com.ar4i.cats.app.CatsApp;

import io.reactivex.Single;

public class SystemRepository implements ISystemRepository {

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
                res = CatsApp.getInstance()
                        .checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                        CatsApp.getInstance()
                                .checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                        CatsApp.getInstance()
                                .checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
            }
            emitter.onSuccess(res);
        });
    }

    // endregion-------------------------------------Public Methods---------------------------------


    // region========================================Private Methods================================

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
