package com.example.kotlin_wanandroid_demo.app.data

data class BaseResponse<T>(
        val errorCode: Int,
        val errorMsg: String,
        val data: T
) {
    val SUCCESS = 1
    val FAIL = 0

    fun isSuccess() = errorCode == 0

}