package com.example.newsapp.android

import android.app.Application
import com.example.newsapp.android.ui.HomeViewModel
import com.example.newsapp.initKoin
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class NewsApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(
            module {
                single { this@NewsApplication }
                viewModel { HomeViewModel(get(), get()) }
            }
        )
    }
}