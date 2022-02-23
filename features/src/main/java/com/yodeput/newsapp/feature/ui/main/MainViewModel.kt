/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yodeput.newsapp.common.util.ViewState
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.core.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject
constructor(private val repo: NewsRepository) : ViewModel() {

    private val _headlineState = MutableStateFlow<ViewState<List<News>>>(ViewState.Idle)
    val headlineState: StateFlow<ViewState<List<News>>>
        get() = _headlineState

    val _newsState = MutableStateFlow<ViewState<List<News>>>(ViewState.Idle)
    val newsState: StateFlow<ViewState<List<News>>>
        get() = _newsState


    val categories = listOf(
        "general",
        "business",
        "entertainment",
        "technology",
        "health",
        "science",
        "sports",
    )

    init {
        getHeadline()
        //getBySource()
        getByCategories(category = "general")
    }

    fun getHeadline(isRefresh: Boolean = false) {
        viewModelScope.launch {
            repo.getHeadline(isRefresh).collectLatest {
                _headlineState.tryEmit(it)
            }
        }
    }

    fun getBySource(isRefresh: Boolean = false, source: String = "") {
        val query = mapOf(
            "language" to "en",
            "country" to "us",
            "sortBy" to "publishedAt",
        )
        if(source.isNotEmpty()){
            query + mapOf(
                "source" to source)
        }
        viewModelScope.launch {
            repo.getBySource(isRefresh, query).collectLatest {
                _newsState.tryEmit(it)
            }
        }
    }

    fun getByCategories(isRefresh: Boolean = false, category: String = "") {
        val query = mapOf(
            "language" to "en",
            "country" to "us",
            "sortBy" to "publishedAt",
            "category" to category,
        )
        viewModelScope.launch {
            repo.getByCategory(isRefresh, query).collectLatest {
                _newsState.tryEmit(it)
            }
        }
    }

}