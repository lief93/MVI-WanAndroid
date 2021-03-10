package com.example.home.presentation.home

import androidx.lifecycle.viewModelScope
import com.example.home.domain.model.FeedArticleDomainModel
import com.example.home.domain.usecase.HomeUseCase
import com.example.kotlin_wanandroid_demo.app.data.ResultState
import com.example.kotlin_wanandroid_demo.app.network.AppException
import com.igorwojda.showcase.library.base.presentation.viewmodel.BaseAction
import com.igorwojda.showcase.library.base.presentation.viewmodel.BaseViewModel
import com.igorwojda.showcase.library.base.presentation.viewmodel.BaseViewState
import kotlinx.coroutines.launch

internal class HomeViewModel(private val homeUseCase: HomeUseCase) :
    BaseViewModel<HomeViewModel.ViewState, HomeViewModel.Action>(ViewState()) {


    override fun onLoadData() {
        loadFeedArticleList(0)
    }

    private fun loadFeedArticleList(pageNum: Int) {
        viewModelScope.launch {
            homeUseCase.loadFeedArticleList(pageNum).also {
                when {
                    it is ResultState.Success -> {
                        sendAction(Action.loadFeedArticleListSuccess(it.data))
                    }
                    it is ResultState.Error -> {
                        sendAction(Action.loadFeedArticleListFail(it.error))
                    }
                }
            }
        }
    }

    internal sealed class Action : BaseAction {
        class loadFeedArticleListSuccess(val articleList: List<FeedArticleDomainModel>) : Action()
        class loadFeedArticleListFail(val e: AppException) : Action()
    }

    internal data class ViewState(
        val articles: List<FeedArticleDomainModel> = listOf(),
        val loadFeedArticlesError : Boolean = false
    ) : BaseViewState

    override fun onReduceState(viewAction: Action) = when(viewAction){
        is Action.loadFeedArticleListSuccess->state.copy(
            loadFeedArticlesError = false,
            articles = viewAction.articleList
        )
        is Action.loadFeedArticleListFail->state.copy(
            loadFeedArticlesError = true,
            articles = listOf()
        )
    }
}