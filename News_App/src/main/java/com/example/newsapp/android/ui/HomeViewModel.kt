package com.example.newsapp.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.interactor.HomePageInteractor
import com.example.newsapp.interactor.HomePageResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val homePageInteractor: HomePageInteractor) : ViewModel() {

    private val _topNewsResults = MutableLiveData<HomePageResults>()

    val topNewsResults: LiveData<HomePageResults> = _topNewsResults

    fun getHomePageResults() {
        viewModelScope.launch(Dispatchers.IO) {
            val results = homePageInteractor.fetchHomePageResults()
            _topNewsResults.postValue(results)
        }
    }
}