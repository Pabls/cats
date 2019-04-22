package com.ar4i.cats.data.repositories.system;

import io.reactivex.Single;

public interface ISystemRepository {
    Single<Boolean> hasNetworkConnection();
    Single<Boolean> hasPermissions();
    Single<Boolean> hasExternalStoragePermissions();
    Single<Boolean> hasCameraPermissions();
}
