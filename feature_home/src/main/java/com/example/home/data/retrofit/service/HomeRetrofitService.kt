package com.example.home.data.retrofit.service

import com.example.home.data.retrofit.response.FeedArticleListData
import com.example.kotlin_wanandroid_demo.app.data.BaseResponse
import retrofit2.http.GET
import retrofit2.http.Path

internal interface HomeRetrofitService {
    @GET("article/list/{num}/json")
    suspend fun getFeedArticleList(@Path("num") num : Int) : BaseResponse<FeedArticleListData>

}