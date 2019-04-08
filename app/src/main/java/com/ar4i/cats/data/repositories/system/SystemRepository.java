package com.ar4i.cats.data.repositories.system;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import com.ar4i.cats.app.CatsApp;

import io.reactivex.Single;

public class SystemRepository implements ISystemRepository {

    // region========================================Public Methods=================================

    @Override
    public Single<Boolean> isWiFiEnabled() {
        return Single.create(emitter -> emitter.onSuccess(isWiFiWorking()));
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

    private boolean isWiFiWorking() {
        boolean res = false;
        final ConnectivityManager cm = CatsApp.getService();
        if (cm != null) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                final NetworkInfo ni = cm.getActiveNetworkInfo();
                if (ni != null) {
                    res = (ni.isConnected() && (ni.getType() == ConnectivityManager.TYPE_WIFI));
                }
            } else {
                final Network n = cm.getActiveNetwork();
                if (n != null) {
                    final NetworkCapabilities nc = cm.getNetworkCapabilities(n);
                    res = nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
                }
            }
        }
        return res;
    }

    // endregion-------------------------------------Private Methods--------------------------------
}
