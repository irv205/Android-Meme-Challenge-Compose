package com.kk.memechallengecompose.core.utils

sealed class ResponseHandler<T>{
    data class Success<T>(val data: T) : ResponseHandler<T>()
    data class Error<T>(val message: String) : ResponseHandler<T>()
}