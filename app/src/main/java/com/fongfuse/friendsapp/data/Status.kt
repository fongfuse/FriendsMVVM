package com.fongfuse.friendsapp.data

sealed class Status<out T> {
    data class Success<T>(val data: T?) : Status<T>()
    data class Error<T>(val statusCode: Int?, val errorMessage: String?) : Status<T>()
    object Loading : Status<Nothing>()
}