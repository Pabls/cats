package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.mappers.BreedMapper;
import com.ar4i.cats.data.mappers.CategoryMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Provides
    BreedMapper provideBreedsMapper() {
        return new BreedMapper();
    }

    @Provides
    CategoryMapper provideCategoryMapper() {
        return new CategoryMapper();
    }
}
