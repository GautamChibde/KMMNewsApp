package com.example.newsapp

import com.example.newsapp.interactor.FeedsIntaractor
import com.example.newsapp.interactor.HomePageResults
import com.example.newsapp.model.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.native.concurrent.ensureNeverFrozen

class NativeFeedsIntaractor(
    private val onLoading: () -> Unit,
    private val onSuccess: (HomePageResults) -> Unit,
    private val onError: (String) -> Unit,
    private val onEmpty: () -> Unit
) : KoinComponent {

    private val scope = MainScope(Dispatchers.Main)
    private val feedsIntaractor: FeedsIntaractor by inject()

    init {
        ensureNeverFrozen()
    }

    fun fetchResults() {
        observeFeedResults()
    }

    private fun observeFeedResults() {
        scope.launch {
            when(val results = feedsIntaractor.fetchHomePageResults()) {
                is DataState.Success -> {
                    onSuccess(results.data)
                }
                is DataState.Error -> {
                    onError(results.exception)
                }
                DataState.Empty -> {
                    onEmpty()
                }
                DataState.Loading -> {
                    onLoading()
                }
            }
        }
    }

    fun onDestroy() {
        scope.onDestroy()
    }
}