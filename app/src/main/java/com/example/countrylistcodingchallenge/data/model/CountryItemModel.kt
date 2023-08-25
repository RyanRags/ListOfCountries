package com.example.countrylistcodingchallenge.data.model

data class CountryItemModel(
    val capital: String,
    val code: String,
    val currency: CurrencyModel,
    val demonym: String,
    val flag: String,
    val language: LanguageModel,
    val name: String,
    val region: String
)