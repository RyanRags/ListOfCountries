package com.example.countrylistcodingchallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countrylistcodingchallenge.data.remote.ApiRequest
import com.example.countrylistcodingchallenge.data.model.CountryModel
import com.example.countrylistcodingchallenge.data.remote.ApiResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.IOException

class CountryViewModel : ViewModel(), KoinComponent {
    private val countryApi: ApiRequest by inject()

    private val _uiState: MutableStateFlow<ApiResult<CountryModel>> =
        MutableStateFlow(ApiResult.Loading(null))
    val uiState: StateFlow<ApiResult<CountryModel>> = _uiState

    init {
        viewModelScope.launch {
            try {

                val response = countryApi.getCountryList()

                if (response.isSuccessful && !response.body().isNullOrEmpty()) {
                    _uiState.value = ApiResult.ApiSuccess(response.body()!!)
                } else {
                    _uiState.value = ApiResult.ApiError(response.message())
                }

            } catch (e: IOException) {
                _uiState.value = ApiResult.ApiError("API Error")
            }
        }
    }
}