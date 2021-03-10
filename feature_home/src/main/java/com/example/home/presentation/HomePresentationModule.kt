package com.example.home.presentation

import androidx.fragment.app.Fragment
import com.example.featureHome.R
import com.example.home.MODULE_NAME
import com.example.home.presentation.home.ArticleListAdapter
import com.example.home.presentation.home.HomeViewModel
import com.igorwojda.showcase.library.base.di.KotlinViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule"){
    bind<HomeViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context){HomeViewModel(instance())}
    }

    bind() from singleton { ArticleListAdapter(R.layout.item_search_pager, listOf()) }

}