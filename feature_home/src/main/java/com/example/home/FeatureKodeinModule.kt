package com.example.home

import com.example.home.data.dataModule
import com.example.home.domain.domainModule
import com.example.home.presentation.presentationModule
import com.example.kotlin_wanandroid_demo.app.feature.KodeinModuleProvider
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Home"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
