package com.ar4i.cats.data.repositories.favorites;

import com.ar4i.cats.data.network.Api;

public class FavoritesRepository implements IFavoritesRepository {

    public FavoritesRepository(Api api) { this.api = api; }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------


}
