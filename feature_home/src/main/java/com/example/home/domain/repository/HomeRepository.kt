package com.example.home.domain.repository

import com.example.home.domain.model.FeedArticleDomainModel
import com.example.kotlin_wanandroid_demo.app.data.ResultState

internal interface HomeRepository {
    suspend fun getFeedArticleList(pageNum : Int) : ResultState<List<FeedArticleDomainModel>>
}