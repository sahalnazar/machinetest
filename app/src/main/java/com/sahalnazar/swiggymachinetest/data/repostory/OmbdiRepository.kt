package com.sahalnazar.swiggymachinetest.data.repostory

import com.sahalnazar.swiggymachinetest.data.remote.ObdmService
import com.sahalnazar.swiggymachinetest.utils.safeApiCall
import javax.inject.Inject

class OmbdiRepository @Inject constructor(private val obdmService: ObdmService) {

    suspend fun fetchMovieDetails(movieId: String) = safeApiCall {
        obdmService.movieDetail(movieId = movieId)
    }

    suspend fun searchMovies(searchItem: String, page: String) = safeApiCall {
        obdmService.movieSearch(searchedItem = searchItem, page = page)
    }
}