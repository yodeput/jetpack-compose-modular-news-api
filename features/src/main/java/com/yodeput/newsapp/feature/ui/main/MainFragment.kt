/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.yodeput.newsapp.common.util.ViewState
import com.yodeput.newsapp.feature.base.BaseFragment
import com.yodeput.newsapp.feature.ui.common.ShimmerHeadline
import com.yodeput.newsapp.feature.ui.main.components.CategoriesTab
import com.yodeput.newsapp.feature.ui.main.components.HeadlineNews
import com.yodeput.newsapp.feature.ui.main.components.Topbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(
        ExperimentalMaterial3Api::class,
        ExperimentalPagerApi::class
    )
    @Composable
    override fun setContent() {
        val headlineState = viewModel.headlineState.collectAsState().value
        val newsState = viewModel.newsState.collectAsState().value
        Scaffold(
            topBar = {
                Topbar()
            },
        ) {
            val selectedTab = remember { mutableStateOf(0) }
            SwipeRefresh(
                state = rememberSwipeRefreshState(isRefreshing = false),
                onRefresh = {
                    viewModel.getByCategories(true, viewModel.categories[selectedTab.value])
                    viewModel.getHeadline(true)
                },
            ) {
                Column() {
                    Box(
                        Modifier
                            .height(240.dp)
                            .fillMaxWidth()
                    ) {
                        when (headlineState) {
                            is ViewState.Loading -> {
                                ShimmerHeadline()
                            }
                            is ViewState.Success -> {
                                HeadlineNews(data = headlineState.data.take(5)) { news ->
                                    val detail = MainFragmentDirections.actionMainFragmentToDetailFragment(news)
                                    goToScreen(directions = detail)
                                }
                            }
                            is ViewState.Error -> {}
                        }
                    }
                    CategoriesTab(
                        viewModel = viewModel,
                        selectedTab = selectedTab,
                        onSelected = { news ->
                            val detail = MainFragmentDirections.actionMainFragmentToDetailFragment(news)
                            goToScreen(directions = detail)
                        },
                    )
                }
            }
        }
    }


}


