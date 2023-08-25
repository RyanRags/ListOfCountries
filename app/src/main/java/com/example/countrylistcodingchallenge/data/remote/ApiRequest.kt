package com.example.countrylistcodingchallenge.data.remote

import com.example.countrylistcodingchallenge.data.model.CountryModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiRequest {

    @GET("peymano-wmt/32dcb892b06648910ddd40406e37fdab/raw/db25946fd77c5873b0303b858e861ce724e0dcd0/countries.json")
    suspend fun getCountryList(): Response<CountryModel>
}