package com.example.public


import com.example.kotlin_wanandroid_demo.app.feature.KodeinModuleProvider
import com.example.public.data.dataModule
import com.example.public.domain.domainModule
import com.example.public.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Public"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
