package com.ar4i.cats.domain.interactors.system;

import io.reactivex.Single;

public interface ISystemInteractor {
    Single<Boolean> hasNetworkConnection();
}
