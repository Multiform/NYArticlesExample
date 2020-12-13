package com.multiform.nyarticlesexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multiform.nyarticlesexample.models.Article
import com.multiform.nyarticlesexample.network.NYTimesApiClient
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val _items = MutableLiveData<List<Article>>()
    val items: LiveData<List<Article>> get() = _items

    init {
        viewModelScope.launch {
            _items.value = NYTimesApiClient.getOneDayArticlesList()
        }
    }

    fun getOneDayList() {
        viewModelScope.launch {
            _items.value = NYTimesApiClient.getOneDayArticlesList()
        }
    }

    fun getSevenDaysList() {
        viewModelScope.launch {
            _items.value = NYTimesApiClient.getSevenDaysArticlesList()
        }
    }

    fun getThirtyDaysList() {
        viewModelScope.launch {
            _items.value = NYTimesApiClient.getThirtyDaysArticlesList()
        }
    }
}