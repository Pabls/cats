package com.ar4i.cats.data.network;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.data.network.response.Category;
import com.ar4i.cats.data.network.response.DataChangeResponse;
import com.ar4i.cats.data.network.response.FullImgData;
import com.ar4i.cats.data.network.response.Vote;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    static String VERSION = "v1";

    //==========================================start Breeds========================================

    /**
     * https://api.thecatapi.com/v1/breeds
     */
    @GET(VERSION + "/breeds")
    Single<List<Breed>> getBreeds();

    /**
     * https://api.thecatapi.com/v1/breeds?q=sib
     */
    @GET(VERSION + "/breeds/search")
    Single<List<Breed>> getBreedsByName(@Query("q") String name);

    //-------------------------------------------end Breeds-----------------------------------------


    //==========================================start Categories====================================

    /**
     * https://api.thecatapi.com/v1/categories
     */
    @GET(VERSION + "/categories")
    Single<List<Category>> getCategories();

    //-------------------------------------------end Categories-------------------------------------


    //==========================================start Images========================================

    /**
     * https://api.thecatapi.com/v1/images/search?size=small&mime-types=png&format=json&limit=1&breed_id=bsho
     */
    @GET(VERSION + "/images/search")
    Single<List<FullImgData>> getImages(@Query("size") String size,
                                        @Query("mime-types") String mimeType,
                                        @Query("order") String order,
                                        @Query("limit") int limit,
                                        @Query("category_ids") List<Integer> categoryIds,
                                        @Query("format") String format,
                                        @Query("breed_id") String breedsIds);


    /**
     * https://api.thecatapi.com/v1/images/GrPErz7EA
     */
    @GET(VERSION + "/images")
    Single<FullImgData> getImageById(@Path("image_id") String imageId);

    @POST(VERSION + "/images/upload")
    Single<DataChangeResponse> uploadImage(@Body() Object img);

    @POST(VERSION + "/images")
    Single<DataChangeResponse> deleteImageById(@Path("image_id") String imageId);

    //-------------------------------------------end Images-----------------------------------------


    //==========================================start Votes=========================================

    /**
     * https://api.thecatapi.com/v1/votes
     */
    @GET(VERSION + "/votes")
    Single<List<Vote>> getVotes();

    /**
     * https://api.thecatapi.com/v1/votes/31098
     */
    @GET(VERSION + "/votes")
    Single<Vote> getVoteById(@Path("id") String voteId);


    @POST(VERSION + "/votes")
    Single<DataChangeResponse> createVotes(@Body() Object vote);

    @DELETE(VERSION + "/votes")
    Single<DataChangeResponse> deleteVoteById(@Path("id") String voteId);

    //-------------------------------------------end Votes------------------------------------------
}
