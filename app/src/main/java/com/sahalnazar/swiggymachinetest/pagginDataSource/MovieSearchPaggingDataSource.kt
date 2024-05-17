package com.sahalnazar.swiggymachinetest.pagginDataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sahalnazar.swiggymachinetest.data.model.SearchResponse
import com.sahalnazar.swiggymachinetest.data.remote.ResponseState
import com.sahalnazar.swiggymachinetest.data.repostory.OmbdiRepository
import retrofit2.HttpException
import java.io.IOException

//class MovieSearchPaggingDataSource(
//    private val remoteDataSource: OmbdiRepository,
//) : PagingSource<Int, SearchResponse>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchResponse.Search> {
//        val position = params.key ?: 1
//        return when(val result = remoteDataSource.searchMovies("", position.toString())){
//            is ResponseState.Error -> LoadResult.Error(Exception(result.toString()))
//            is ResponseState.Success -> {
//                LoadResult.Page(data = result.item.search.orEmpty(),
//                    nextKey = if (result.item.search.isNullOrEmpty()) null else position + 1,
//                    prevKey = null)
//            }
//
//            else -> {}
//        }
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, SearchResponse>): Int? {
//        return state.anchorPosition
//    }
//
//}