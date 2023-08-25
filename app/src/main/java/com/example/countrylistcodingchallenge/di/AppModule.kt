package com.example.countrylistcodingchallenge.di

import com.example.countrylistcodingchallenge.data.remote.ApiRequest
import com.example.countrylistcodingchallenge.ui.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://gist.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        val retrofit: Retrofit = get()
        retrofit.create(ApiRequest::class.java)
    }
}

val viewModelModule = module {
    viewModelOf(::CountryViewModel)
}