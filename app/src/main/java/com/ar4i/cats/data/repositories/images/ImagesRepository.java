package com.ar4i.cats.data.repositories.images;

import com.ar4i.cats.data.mappers.IVmMapper;
import com.ar4i.cats.data.network.Api;
import com.ar4i.cats.data.network.request.DataFormat;
import com.ar4i.cats.data.network.request.ImageMimeType;
import com.ar4i.cats.data.network.request.ImageSize;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class ImagesRepository implements IImagesRepository {

    public ImagesRepository(Api api, IVmMapper iVmMapper) {
        this.api = api;
        this.iVmMapper = iVmMapper;
    }

    //==========================================start FIELDS========================================

    private Api api;
    private IVmMapper iVmMapper;

    //-------------------------------------------end FIELDS-----------------------------------------


    // region========================================implements IImagesRepository===================

    @Override
    public Single<String> getRandomImage() {
        return this.api.getImages(ImageSize.SMALL,
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

    @Override
    public Single<List<String>> getImagesByCategory(int categoryId) {
        return this.api.getImages(ImageSize.FULL,
                ImageMimeType.PNG,
                null,
                100,
                new ArrayList<>(categoryId),
                DataFormat.JSON,
                null)
                .map(fullImgData -> iVmMapper.mapToViewModel(fullImgData));
    }

    // endregion-------------------------------------implements IImagesRepository-------------------
}
