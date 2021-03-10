package com.example.kotlin_wanandroid_demo.app.network

class AppException : Exception {
    var errorCode: Int = 0
    var errorMsg: String
    var errorLog: String?

    constructor(errorCode: Int, errorMsg: String ?= "请求失败，请稍后再试", errorLog: String? = "") : super(errorMsg) {
        this.errorCode = errorCode
        this.errorMsg = errorMsg ?: "请求失败，请稍后再试"
        this.errorLog = errorLog ?: this.errorMsg
    }

    constructor(error: Error, e: Throwable?) {
        errorCode = error.getKey()
        errorMsg = error.getValue()
        errorLog = e?.message
    }

}