package com.sahalnazar.swiggymachinetest.data.remote

import com.sahalnazar.swiggymachinetest.data.model.DetailResponse
import com.sahalnazar.swiggymachinetest.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ObdmService {

    @GET("/")
    suspend fun movieSearch(
        @Query("apikey") apikey: String = "da7b1b3c",
        @Query("s") searchedItem: String,
        @Query("page") page: String,
    ): ResponseState<SearchResponse>


    @GET("/")
    suspend fun movieDetail(
        @Query("apikey") apikey: String = "da7b1b3c",
        @Query("i") movieId: String,
    ): ResponseState<DetailResponse>
}

sealed class ResponseState<out T> {
    data class Error(val throwable: Throwable) : ResponseState<Nothing>()
    data class Success<T>(val item: T) : ResponseState<T>()
}