package com.ar4i.cats.data.network;

import com.ar4i.cats.data.network.response.Breed;
import com.ar4i.cats.data.network.response.Category;
import com.ar4i.cats.data.network.response.DataChangeResponse;
import com.ar4i.cats.data.network.response.FullData;
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

    //==========================================start Breeds========================================

    /**
     * https://api.thecatapi.com/v1/breeds
     */
    @GET("/breeds")
    Single<List<Breed>> getBreeds();

    /**
     * https://api.thecatapi.com/v1/breeds?q=sib
     */
    @GET("/breeds/search")
    Single<List<Breed>>  getBreedsByName(@Query("q") String name);

    //-------------------------------------------end Breeds-----------------------------------------


    //==========================================start Categories====================================

    /**
     * https://api.thecatapi.com/v1/categories
     */
    @GET("/categories")
    Single<List<Category>>  getCategories();

    //-------------------------------------------end Categories-------------------------------------


    //==========================================start Images========================================

    /**
     * https://api.thecatapi.com/v1/images/search?size=small&mime-types=png&format=json&limit=1&breed_id=bsho
     */
    @GET("/images/search")
    Single<List<FullData>>  getImages(@Query("size") String size,
                                      @Query("mime-types") String mimeType,
                                      @Query("order") String order,
                                      @Query("limit") int limit,
                                      @Query("category_ids") List<Integer> categoryIds,
                                      @Query("format") String format,
                                      @Query("breed_id") String breedsIds);


    /**
     * https://api.thecatapi.com/v1/images/GrPErz7EA
     */
    @GET("/images")
    Single<FullData> getImageById(@Path("image_id") String imageId);

    @POST("/images/upload")
    Single<DataChangeResponse> uploadImage(@Body() Object img);

    @POST("/images")
    Single<DataChangeResponse> deleteImageById(@Path("image_id") String imageId);

    //-------------------------------------------end Images-----------------------------------------


    //==========================================start Votes=========================================

    /**
     * https://api.thecatapi.com/v1/votes
     */
    @GET("/votes")
    Single<List<Vote>>  getVotes();

    /**
     * https://api.thecatapi.com/v1/votes/31098
     */
    @GET("/votes")
    Single<Vote> getVoteById(@Path("id") String voteId);


    @POST("/votes")
    Single<DataChangeResponse> createVotes(@Body() Object vote);

    @DELETE("/votes")
    Single<DataChangeResponse> deleteVoteById(@Path("id") String voteId);

    //-------------------------------------------end Votes------------------------------------------
}
