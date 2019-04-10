package com.ar4i.cats.app.di.modules;

import com.ar4i.cats.data.mappers.BreedMapper;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {

    @Provides
    BreedMapper provideBreedsMapper() {
        return new BreedMapper();
    }
}
