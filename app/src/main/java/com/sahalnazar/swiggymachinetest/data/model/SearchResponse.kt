package com.sahalnazar.swiggymachinetest.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("Response")
    val response: String? = null,
    @SerialName("Search")
    val search: List<Search?>? = null,
    @SerialName("totalResults")
    val totalResults: String? = null
) {
    @Serializable
    data class Search(
        @SerialName("imdbID")
        val imdbID: String? = null,
        @SerialName("Poster")
        val poster: String? = null,
        @SerialName("Title")
        val title: String? = null,
        @SerialName("Type")
        val type: String? = null,
        @SerialName("Year")
        val year: String? = null
    )
}