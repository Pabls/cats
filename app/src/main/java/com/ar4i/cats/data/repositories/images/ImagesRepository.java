package com.ar4i.cats.data.repositories.images;

import com.ar4i.cats.data.network.Api;

public class ImagesRepository implements IImagesRepository {

    public ImagesRepository(Api api) { this.api = api; }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------
}
