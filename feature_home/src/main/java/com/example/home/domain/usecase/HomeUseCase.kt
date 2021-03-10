package com.example.home.domain.usecase

import com.example.home.domain.model.FeedArticleDomainModel
import com.example.home.domain.repository.HomeRepository
import com.example.kotlin_wanandroid_demo.app.data.ResultState

internal class HomeUseCase(private val homeRepository: HomeRepository) {
    suspend fun loadFeedArticleList(pageNum:Int) : ResultState<List<FeedArticleDomainModel>>{
       return homeRepository.getFeedArticleList(pageNum)
    }
}