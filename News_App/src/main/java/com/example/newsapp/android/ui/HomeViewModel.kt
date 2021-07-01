package com.example.newsapp.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.NewsAppHttpClient
import com.example.newsapp.model.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {


    private val _topNewsResults = MutableLiveData<List<Article>>()

    val topNewsResults: LiveData<List<Article>> = _topNewsResults

    fun fetchTopNews() {
        val httpClient = NewsAppHttpClient()
        viewModelScope.launch(Dispatchers.IO) {
            val topNews = httpClient.getTopHeadLines()
            _topNewsResults.postValue(topNews.articles)
        }
    }
}