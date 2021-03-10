package com.example.knowledge
import com.example.knowledge.domain.domainModule
import com.example.knowledge.presentation.presentationModule
import com.example.kotlin_wanandroid_demo.app.feature.KodeinModuleProvider
import dataModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Knowledge"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
