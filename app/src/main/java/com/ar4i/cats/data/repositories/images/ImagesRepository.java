package com.ar4i.cats.data.repositories.images;

import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.request.DataFormat;
import com.ar4i.cats.data.network.request.ImageMimeType;
import com.ar4i.cats.data.network.request.ImageSize;

import io.reactivex.Single;

public class ImagesRepository implements IImagesRepository {

    public ImagesRepository(Api api) { this.api = api; }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------


    // region========================================implements IImagesRepository===================

    @Override
    public Single<String> getRandomImage() {
        return this.api.getImages(ImageSize.THUMB,
                ImageMimeType.GIF,
                null,
                1,
                null,
                DataFormat.JSON,
                null)
                .map(fullImgData -> fullImgData.get(0).getUrl());
    }

    @Override
    public Single<String> getImageByBreedId(String breedId) {
        return this.api.getImages(ImageSize.THUMB,
                ImageMimeType.GIF,
                null,
                1,
                null,
                DataFormat.JSON,
                breedId)
                .map(fullImgData -> fullImgData.get(0).getUrl());
    }

    // endregion-------------------------------------implements IImagesRepository-------------------
}
