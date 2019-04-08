package com.ar4i.cats.data.repositories.system;

import io.reactivex.Single;

public interface ISystemRepository {
    Single<Boolean> isWiFiEnabled();
    Single<Boolean> hasPermissions();
}
