package com.example.home.presentation.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.featureHome.R
import com.igorwojda.showcase.library.base.presentation.extension.observe
import com.igorwojda.showcase.library.base.presentation.fragment.InjectionFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.kodein.di.generic.instance

class HomeFragment : InjectionFragment(R.layout.fragment_home) {
    private val viewModel: HomeViewModel by instance()
    private val articleListAdapter: ArticleListAdapter by instance()
    private val stateObserver = Observer<HomeViewModel.ViewState> {
        articleListAdapter.feedArticles = it.articles
        mainPageRecyclerView.visibility =
            if (it.loadFeedArticlesError) View.INVISIBLE else View.VISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }

    private fun initRecyclerView() {
        mainPageRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = articleListAdapter
        }
        articleListAdapter.setOnItemClickListener { _, view, position ->
            startArticleDetailPager(
                view,
                position
            )
        }
        articleListAdapter.setOnItemChildClickListener { _, view, position ->
            clickChildEvent(view, position)
        }

    }

    private fun startArticleDetailPager(view: View, position: Int) {

    }

    private fun clickChildEvent(view: View, position: Int) {

    }
}
