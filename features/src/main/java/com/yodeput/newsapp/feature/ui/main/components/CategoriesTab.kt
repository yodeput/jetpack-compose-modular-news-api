/*
 * Created by Yogi Dewansyah
 * URL: https://github.com/yodeput
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 2/23/22, 10:25 PM
 *
 */

package com.yodeput.newsapp.feature.ui.main.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.yodeput.newsapp.common.util.ViewState
import com.yodeput.newsapp.core.model.News
import com.yodeput.newsapp.feature.ui.common.ShimmerNews
import com.yodeput.newsapp.feature.ui.main.MainViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun CategoriesTab(
    viewModel: MainViewModel,
    selectedTab: MutableState<Int>,
    onSelected: (News) -> Unit,
) {
    val newsState = viewModel.newsState.collectAsState().value
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        edgePadding = 10.dp,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {

        viewModel.categories.forEachIndexed { index, item ->
            Tab(
                selected = index == pagerState.currentPage,
                onClick = {
                    viewModel._newsState.tryEmit(ViewState.Loading)
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                        selectedTab.value = index
                    }
                }
            ) {
                ChoiceChipContent(
                    text = item,
                    selected = index == pagerState.currentPage,
                    modifier = Modifier
                        .padding(horizontal = 5.dp, vertical = 10.dp)
                )
            }
        }
    }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            viewModel.getByCategories(true, viewModel.categories[page])
        }
    }
    HorizontalPager(
        userScrollEnabled = false,
        count = viewModel.categories.size,
        state = pagerState,
    ) {
        Box(Modifier.padding(horizontal = 10.dp)) {
            when (newsState) {
                is ViewState.Loading -> {
                    ShimmerNews()
                }
                is ViewState.Success -> {
                    ListNews(newsState.data) {
                        onSelected(it)
                    }
                }
                is ViewState.Error -> {}
            }
        }
    }
}

@Composable
private fun ChoiceChipContent(
    text: String,
    selected: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = when {
            selected -> MaterialTheme.colorScheme.onPrimaryContainer
            else -> MaterialTheme.colorScheme.primaryContainer
        },
        shape = RoundedCornerShape(28.dp),
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = text.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = when {
                        selected -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.onPrimaryContainer
                    }
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 5.dp),
            )
        }
    }
}