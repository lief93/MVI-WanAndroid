package com.example.kotlin_wanandroid_demo.app.data

import com.example.kotlin_wanandroid_demo.app.network.AppException

sealed class ResultState<out T> {
    companion object {
        fun <T> onAppSuccess(data: T): ResultState<T> = Success(data)
        fun <T> onAppError(error: AppException): ResultState<T> = Error(error)
    }

    data class Success<T>(val data: T) : ResultState<T>()
    data class Error(val error: AppException) : ResultState<Nothing>()
}