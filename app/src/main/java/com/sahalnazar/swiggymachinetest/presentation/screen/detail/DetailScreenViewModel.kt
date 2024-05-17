package com.sahalnazar.swiggymachinetest.presentation.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahalnazar.swiggymachinetest.data.model.DetailResponse
import com.sahalnazar.swiggymachinetest.data.model.SearchResponse
import com.sahalnazar.swiggymachinetest.data.remote.ResponseState
import com.sahalnazar.swiggymachinetest.data.repostory.OmbdiRepository
import com.sahalnazar.swiggymachinetest.presentation.screen.home.HomeScreenUiStates
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val ombdiRepository: OmbdiRepository
): ViewModel() {

    private val _uiState = MutableStateFlow(DetailScreenUiStates())
    val uiState = _uiState.asStateFlow()

    fun searchMovie(moviewId: String) = viewModelScope.launch {
        _uiState.update {
            it.copy(isLoading = true)
        }
        when (val result = ombdiRepository.fetchMovieDetails(movieId = moviewId)) {
            is ResponseState.Success -> {
                _uiState.update {
                    it.copy(isLoading = false, searchResponse = result.item, isError = false)
                }
            }

            is ResponseState.Error -> {
                _uiState.update {
                    it.copy(isLoading = false, searchResponse = null, isError = true)
                }
            }

            else -> {}
        }
    }

}

data class DetailScreenUiStates(
    val searchItem: String = "",

    val searchResponse: DetailResponse? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)