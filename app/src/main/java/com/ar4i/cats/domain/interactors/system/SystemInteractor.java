package com.ar4i.cats.domain.interactors.system;

import com.ar4i.cats.data.repositories.system.ISystemRepository;

import io.reactivex.Single;

public class SystemInteractor implements ISystemInteractor {

    public SystemInteractor(ISystemRepository iSystemRepository) {
        this.iSystemRepository = iSystemRepository;
    }

    // region========================================Fields=========================================

    private ISystemRepository iSystemRepository;


    // endregion-------------------------------------Fields-----------------------------------------


    // region========================================implements ISystemInteractor===================

    @Override
    public Single<Boolean> hasNetworkConnection() {
        return iSystemRepository.hasNetworkConnection();
    }

    // endregion-------------------------------------implements ISystemInteractor-------------------
}
