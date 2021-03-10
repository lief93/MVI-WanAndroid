package com.example.home.domain

import com.example.home.MODULE_NAME
import com.example.home.domain.usecase.HomeUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule"){
    bind() from singleton { HomeUseCase(instance()) }
}