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
    private val onResults: (DataState<List<Article>>) -> Unit,
) : KoinComponent {

    private val scope = MainScope(Dispatchers.Main)
    private val searchIntaractor: SearchIntaractor by inject()

    init {
        ensureNeverFrozen()
    }

    fun searchResults(query: String) {
        scope.launch {
            val results = searchIntaractor.searchResults(query)
            onResults(results)
        }
    }

    fun dispose() {
        scope.onDestroy()
    }
}