package com.example.newsapp.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.interactor.FeedsIntaractor
import com.example.newsapp.interactor.HomePageResults
import com.example.newsapp.interactor.SearchIntaractor
import com.example.newsapp.interactor.SearchResults
import com.example.newsapp.model.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val homePageInteractor: FeedsIntaractor,
    private val searchIntaractor: SearchIntaractor
) : ViewModel() {

    private val _topNewsResults = MutableLiveData<DataState<HomePageResults>>(DataState.Loading)

    val topNewsResults: LiveData<DataState<HomePageResults>> = _topNewsResults


    private val _searchResults = MutableLiveData<DataState<SearchResults>>(DataState.Empty)

    val searchResults: LiveData<DataState<SearchResults>> = _searchResults

    fun getHomePageResults() {
        viewModelScope.launch(Dispatchers.IO) {
            val results = homePageInteractor.fetchHomePageResults()
            _topNewsResults.postValue(results)
        }
    }

    fun searchNewsArticles(query: String) {
        _searchResults.postValue(DataState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            val results = searchIntaractor.searchResults(query = query)
            _searchResults.postValue(results)
        }
    }
}