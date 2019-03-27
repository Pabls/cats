package com.ar4i.cats.data.repositories.votes;

import com.ar4i.cats.data.network.Api;

public class VotesRepository implements IVotesRepository {

    public VotesRepository(Api api) { this.api = api; }

    //==========================================start FIELDS========================================

    private Api api;

    //-------------------------------------------end FIELDS-----------------------------------------

}
