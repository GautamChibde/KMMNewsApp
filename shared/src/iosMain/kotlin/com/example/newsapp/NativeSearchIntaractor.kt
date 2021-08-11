package com.example.newsapp

import com.example.newsapp.interactor.SearchIntaractor
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.native.concurrent.ensureNeverFrozen

class NativeSearchIntaractor(
    private val onLoading: () -> Unit,
    private val onSuccess: (List<Article>) -> Unit,
    private val onError: (String) -> Unit,
    private val onEmpty: () -> Unit
) : KoinComponent {

    private val scope = MainScope(Dispatchers.Main)
    private val searchIntaractor: SearchIntaractor by inject()

    init {
        ensureNeverFrozen()
    }

    fun searchResults(query: String) {
        scope.launch {
            when (val results = searchIntaractor.searchResults(query)) {
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

    fun dispose() {
        scope.onDestroy()
    }
}