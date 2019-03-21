package com.ar4i.cats.data.network;

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

    @GET("/breeds")
    Single<List<Object>> getBreeds();

    @GET("/breeds/search")
    Single<List<Object>>  getBreedsByName(@Query("q") String name);

    //-------------------------------------------end Breeds-----------------------------------------


    //==========================================start Categories====================================

    @GET("/categories")
    Single<List<Object>>  getCategories();

    //-------------------------------------------end Categories-------------------------------------


    //==========================================start Images========================================

    @GET("/images/search")
    Single<List<Object>>  getImages(@Query("size") String size,
                             @Query("mime-types") String mimeType,
                             @Query("order") String order,
                             @Query("limit") int limit,
                             @Query("category_ids") List<Integer> categoryIds,
                             @Query("format") String format,
                             @Query("breed_id") String breedsIds);

    @POST("/images")
    Single<Object> getImageById(@Path("image_id") String imageId);

    @POST("/images/upload")
    Single<Object> uploadImage(@Body() Object img);

    @POST("/images")
    Single<Object> deleteImageById(@Path("image_id") String imageId);

    //-------------------------------------------end Images-----------------------------------------


    //==========================================start Votes=========================================

    @GET("/votes")
    Single<List<Object>>  getVotes();

    @GET("/votes")
    Single<Object> getVoteById(@Path("id") String voteId);


    @POST("/votes")
    Single<Object> createVotes(@Body() Object vote);

    @DELETE("/votes")
    Single<Object> deleteVoteById(@Path("id") String voteId);

    //-------------------------------------------end Votes------------------------------------------
}
