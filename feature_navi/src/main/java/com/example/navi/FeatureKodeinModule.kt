package com.example.navi

import com.example.kotlin_wanandroid_demo.app.feature.KodeinModuleProvider
import com.example.navi.data.dataModule
import com.example.navi.domain.domainModule
import com.example.navi.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Navi"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
