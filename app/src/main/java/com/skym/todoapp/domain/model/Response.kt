package com.skym.todoapp.domain.model

sealed class Response<out T> {
    data class Success<out P>(val data: P) : Response<P>()
    data class Error(val error: String) : Response<Nothing>()
    object Loading : Response<Nothing>()
}
