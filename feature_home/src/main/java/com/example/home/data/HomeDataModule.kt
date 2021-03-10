package com.example.home.data

import com.example.home.MODULE_NAME
import com.example.home.data.repository.HomeRepositoryImpl
import com.example.home.data.retrofit.service.HomeRetrofitService
import com.example.home.domain.repository.HomeRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule"){
    bind<HomeRepository>() with singleton { HomeRepositoryImpl(instance()) }
    bind() from singleton { instance<Retrofit>().create(HomeRetrofitService::class.java) }
}