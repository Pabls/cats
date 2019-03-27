package com.ar4i.cats.data.repositories.breeds;

import com.ar4i.cats.data.network.Api;

public class BreedsRepository implements IBreedsRepository {

    public BreedsRepository(Api api) {
        this.api = api;
    }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------


}
