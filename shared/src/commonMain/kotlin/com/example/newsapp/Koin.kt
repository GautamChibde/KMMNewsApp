package com.example.newsapp

import com.example.newsapp.api.getKtorHttpClient
import com.example.newsapp.interactor.FeedsIntaractor
import com.example.newsapp.interactor.NewsCategoryIntaractor
import com.example.newsapp.interactor.SearchIntaractor
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

fun initKoin(appModule: Module): KoinApplication {
    return startKoin {
        modules(
            appModule,
            coreModule,
        )
    }
}

private val coreModule = module {
    single {
        getKtorHttpClient()
    }

    single { FeedsIntaractor(get()) }
    single { NewsCategoryIntaractor(get()) }
    single { SearchIntaractor(get()) }
}