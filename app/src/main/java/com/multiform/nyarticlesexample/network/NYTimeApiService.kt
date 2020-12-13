package com.multiform.nyarticlesexample.network

import retrofit2.http.GET
import retrofit2.http.Query

interface NYTimesApiService {

    @GET("mostpopular/v2/viewed/1.json")
    suspend fun getOneDayArticlesList(
        @Query("api-key") apiKey: String
    ): ApiData

    @GET("mostpopular/v2/viewed/7.json")
    suspend fun getSevenDaysArticlesList(
        @Query("api-key") apiKey: String
    ): ApiData

    @GET("mostpopular/v2/viewed/30.json")
    suspend fun getThirtyDaysArticlesList(
        @Query("api-key") apiKey: String
    ): ApiData

    @GET("suggest/v1/timestags")
    suspend fun getTagsList(
        @Query("query") query: String,
        @Query("filter") filter: String,
        @Query("api-key") apiKey: String
    )
}