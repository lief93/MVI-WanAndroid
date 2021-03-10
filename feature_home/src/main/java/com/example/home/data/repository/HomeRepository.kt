package com.example.home.data.repository

import com.example.home.data.model.toDomainModel
import com.example.home.data.retrofit.service.HomeRetrofitService
import com.example.home.domain.model.FeedArticleDomainModel
import com.example.home.domain.repository.HomeRepository
import com.example.kotlin_wanandroid_demo.app.data.ResultState
import com.example.kotlin_wanandroid_demo.app.network.AppException
import com.example.kotlin_wanandroid_demo.app.network.ExceptionHandle

internal class HomeRepositoryImpl(private val homeRetrofitService: HomeRetrofitService) :HomeRepository{

    override suspend fun getFeedArticleList(pageNum : Int): ResultState<List<FeedArticleDomainModel>> {
        var resultState : ResultState<List<FeedArticleDomainModel>> = ResultState.onAppError(AppException(-1))
        kotlin.runCatching {
            homeRetrofitService.getFeedArticleList(pageNum)
        }.onSuccess {
            resultState = if(it.isSuccess()){
                ResultState.onAppSuccess(it.data.datas.map { it.toDomainModel() })
            }else {
                ResultState.onAppError(AppException(it.errorCode,it.errorMsg))
            }
        }.onFailure {
            resultState = ResultState.onAppError(ExceptionHandle.handleException(it))
        }
        return resultState
    }
}