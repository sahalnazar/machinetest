package com.sahalnazar.swiggymachinetest.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sahalnazar.swiggymachinetest.data.model.SearchResponse
import com.sahalnazar.swiggymachinetest.data.remote.ResponseState
import com.sahalnazar.swiggymachinetest.data.repostory.OmbdiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val ombdiRepository: OmbdiRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUiStates())
    val uiState = _uiState.asStateFlow()

   private fun searchMovies(searchItem: String) = viewModelScope.launch {
        _uiState.update {
            it.copy(isLoading = true)
        }
        when (val result = ombdiRepository.searchMovies(searchItem, "1")) {
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

    fun setSearchItem(value: String) {
        _uiState.update {
            it.copy(searchItem = value)
        }
        searchMovies(value)
    }

}

data class HomeScreenUiStates(
    val searchItem: String = "",

    val searchResponse: SearchResponse? = null,
    val isLoading: Boolean = false,
    val isError: Boolean = false
)