package com.example.newsapp.android.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.interactor.NewsCategoryIntaractor
import com.example.newsapp.model.Article
import com.example.newsapp.model.DataState
import com.example.newsapp.model.NewsCategories
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val categoryIntaractor: NewsCategoryIntaractor
) : ViewModel() {

    private val _articles = MutableLiveData<DataState<List<Article>>>()
    val articles: LiveData<DataState<List<Article>>> = _articles

    fun fetchCategoryList(category: NewsCategories) {
        _articles.postValue(DataState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val results = categoryIntaractor.fetchArticlesByCategory(category = category)
            _articles.postValue(results)
        }
    }
}