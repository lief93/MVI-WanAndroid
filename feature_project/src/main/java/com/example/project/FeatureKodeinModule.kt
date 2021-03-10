package com.example.project


import com.example.kotlin_wanandroid_demo.app.feature.KodeinModuleProvider
import com.example.project.data.dataModule
import com.example.project.domain.domainModule
import com.example.project.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Project"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
