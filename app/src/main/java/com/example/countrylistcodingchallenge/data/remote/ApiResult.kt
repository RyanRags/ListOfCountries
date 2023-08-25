package com.example.countrylistcodingchallenge.data.remote

sealed class ApiResult<T>(val value: T? = null, val content: String? = null) {

    class ApiSuccess<T>(value: T) : ApiResult<T>(value)
    class ApiError<T>(content: String, value: T? = null) : ApiResult<T>(value, content)

    class Loading<T>(value: T?) : ApiResult<T>(value)

}