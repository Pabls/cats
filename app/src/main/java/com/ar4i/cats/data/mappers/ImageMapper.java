package com.ar4i.cats.data.mappers;

import com.ar4i.cats.data.network.response.FullImgData;

import java.util.ArrayList;
import java.util.List;

public class ImageMapper implements IVmMapper<String, FullImgData, String> {

    @Override
    public List<String> mapToViewModel(List<FullImgData> data) {
        List<String> imgUrls = new ArrayList<>();
        if (data != null && !data.isEmpty()) {
            for (FullImgData fullImgData : data) {
                imgUrls.add(fullImgData.getUrl());
            }
        }
        return imgUrls;
    }

    @Override
    public List<String> mapToDbEntity(List<FullImgData> data) {
        return null;
    }
}
